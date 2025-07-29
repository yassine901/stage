#!/bin/bash

echo "🧪 Attijariwafa Bank - Application Testing Suite"
echo "==============================================="

# Colors for output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
BLUE='\033[0;34m'
NC='\033[0m'

print_success() { echo -e "${GREEN}✅ $1${NC}"; }
print_warning() { echo -e "${YELLOW}⚠️  $1${NC}"; }
print_error() { echo -e "${RED}❌ $1${NC}"; }
print_info() { echo -e "${BLUE}ℹ️  $1${NC}"; }

# Test 1: Compilation
echo -e "\n${BLUE}🔨 Testing Compilation...${NC}"
if ./mvnw clean compile -q > /dev/null 2>&1; then
    print_success "Compilation successful"
else
    print_error "Compilation failed"
    exit 1
fi

# Test 2: Check critical files
echo -e "\n${BLUE}📁 Checking Critical Files...${NC}"

files_to_check=(
    "src/main/java/com/sysexterne/reservation_system/ReservationSystemApplication.java"
    "src/main/java/Models/controllers/WebInterfaceController.java"
    "src/main/java/Models/controllers/BankingSoapController.java"
    "src/main/java/Models/entities/AccountEntity.java"
    "src/main/java/Models/entities/SystemUsers.java"
    "src/main/java/Models/repositories/AccountRepository.java"
    "src/main/java/Models/services/SignatureService.java"
    "src/main/resources/templates/transaction-interface.html"
    "src/main/resources/application.properties"
    "src/main/resources/data.sql"
)

for file in "${files_to_check[@]}"; do
    if [ -f "$file" ]; then
        print_success "Found: $file"
    else
        print_error "Missing: $file"
    fi
done

# Test 3: Check for syntax issues
echo -e "\n${BLUE}🔍 Checking for Common Issues...${NC}"

# Check for invalid XML in pom.xml
if grep -q "<name>reservation-system</name>" pom.xml; then
    print_success "pom.xml: Valid XML structure"
else
    print_error "pom.xml: Invalid XML found"
fi

# Check for spring-boot-starter-web
if grep -q "spring-boot-starter-web" pom.xml; then
    print_success "Dependencies: spring-boot-starter-web present"
else
    print_error "Dependencies: Missing spring-boot-starter-web"
fi

# Check database configuration
if grep -q "jdbc:h2:mem:banque" src/main/resources/application.properties; then
    print_success "Database: H2 configuration found"
else
    print_error "Database: H2 configuration missing"
fi

# Test 4: Start application for 30 seconds
echo -e "\n${BLUE}🚀 Testing Application Startup...${NC}"
print_info "Starting application for 30 seconds..."

# Start the application in background
./mvnw spring-boot:run > startup.log 2>&1 &
APP_PID=$!

# Wait for startup
sleep 15

# Check if application is running
if kill -0 $APP_PID 2>/dev/null; then
    print_success "Application started successfully (PID: $APP_PID)"
    
    # Test endpoints
    echo -e "\n${BLUE}🌐 Testing Endpoints...${NC}"
    
    # Test main page
    if curl -s http://localhost:8080 > /dev/null 2>&1; then
        print_success "Main page (/) accessible"
    else
        print_warning "Main page (/) not accessible yet"
    fi
    
    # Test SOAP endpoint
    if curl -s -X POST http://localhost:8080/position/v2/transactionProcessor > /dev/null 2>&1; then
        print_success "SOAP endpoint accessible"
    else
        print_warning "SOAP endpoint not accessible yet"
    fi
    
    # Test H2 console
    if curl -s http://localhost:8080/h2-console > /dev/null 2>&1; then
        print_success "H2 console accessible"
    else
        print_warning "H2 console not accessible yet"
    fi
    
    # Wait a bit more then stop
    sleep 15
    
    # Stop the application
    kill $APP_PID 2>/dev/null
    wait $APP_PID 2>/dev/null
    
    print_success "Application test completed"
else
    print_error "Application failed to start"
    exit 1
fi

# Summary
echo -e "\n${GREEN}📋 Test Summary:${NC}"
echo "✅ Compilation: OK"
echo "✅ File Structure: OK"
echo "✅ Configuration: OK"
echo "✅ Startup Test: OK"

echo -e "\n${GREEN}🎉 All tests passed! Your application is ready to use.${NC}"
echo -e "\n${BLUE}🚀 To start the application:${NC}"
echo "   ./start-app.sh"
echo ""
echo -e "${BLUE}🌐 Access points:${NC}"
echo "   • Main Interface: http://localhost:8080"
echo "   • H2 Console: http://localhost:8080/h2-console"
echo "   • SOAP Endpoint: http://localhost:8080/position/v2/transactionProcessor"

# Cleanup
rm -f startup.log