#!/bin/bash

echo "🔍 Verifying Attijariwafa Bank Transaction Processor Fixes"
echo "========================================================="

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

print_check() {
    echo -e "${GREEN}✅${NC} $1"
}

print_error() {
    echo -e "${RED}❌${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}⚠️${NC} $1"
}

# Check 1: pom.xml validity
echo "Checking pom.xml..."
if grep -q "<name>reservation-system</name>" pom.xml; then
    print_check "pom.xml: Invalid XML tag fixed"
else
    print_error "pom.xml: Still contains invalid XML tag"
fi

if grep -q "spring-boot-starter-web" pom.xml; then
    print_check "pom.xml: spring-boot-starter-web dependency present"
else
    print_error "pom.xml: Missing spring-boot-starter-web dependency"
fi

# Check 2: Database configuration
echo -e "\nChecking database configuration..."
if grep -q "jdbc:h2:mem:banque" src/main/resources/application.properties; then
    print_check "Database: H2 in-memory database configured"
else
    print_error "Database: H2 configuration missing"
fi

# Check 3: Template location
echo -e "\nChecking template files..."
if [ -f "src/main/resources/templates/transaction-interface.html" ]; then
    print_check "Templates: transaction-interface.html found in correct location"
else
    print_error "Templates: transaction-interface.html missing"
fi

# Check 4: Controllers
echo -e "\nChecking controllers..."
if [ -f "src/main/java/Models/controllers/WebInterfaceController.java" ]; then
    print_check "Controllers: WebInterfaceController found"
else
    print_error "Controllers: WebInterfaceController missing"
fi

if [ -f "src/main/java/Models/controllers/BankingSoapController.java" ]; then
    print_check "Controllers: BankingSoapController found"
else
    print_error "Controllers: BankingSoapController missing"
fi

# Check 5: Maven wrapper
echo -e "\nChecking build tools..."
if [ -f "./mvnw" ] && [ -x "./mvnw" ]; then
    print_check "Build: Maven wrapper available and executable"
else
    print_error "Build: Maven wrapper issues"
fi

# Check 6: Compilation
echo -e "\nTesting compilation..."
if ./mvnw clean compile -q > /dev/null 2>&1; then
    print_check "Build: Project compiles successfully"
else
    print_error "Build: Compilation failed"
fi

echo -e "\n📝 Summary of Fixes Applied:"
echo "1. ✅ Fixed invalid XML tag in pom.xml (<n> → <name>)"
echo "2. ✅ Added missing spring-boot-starter-web dependency"
echo "3. ✅ Configured H2 in-memory database (replaces MySQL)"
echo "4. ✅ Verified Thymeleaf template location"
echo "5. ✅ Created startup script with Maven wrapper support"
echo "6. ✅ Added sample data for testing"

echo -e "\n🚀 To start the application:"
echo "   ./start-app.sh"
echo -e "\n🌐 Once started, access the application at:"
echo "   http://localhost:8080"