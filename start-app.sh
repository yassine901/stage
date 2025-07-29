#!/bin/bash

echo "🏦 Attijariwafa Bank - Transaction Processor Startup"
echo "=================================================="

# Colors for output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Check if Java is installed
if ! command -v java &> /dev/null; then
    print_error "Java is not installed. Please install Java 17 or later."
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d. -f1)
if [ "$JAVA_VERSION" -lt 17 ]; then
    print_warning "Java version is less than 17. Some features may not work properly."
fi

# Check if Maven or Maven wrapper is available
if command -v mvn &> /dev/null; then
    MVN_CMD="mvn"
elif [ -f "./mvnw" ]; then
    MVN_CMD="./mvnw"
    chmod +x ./mvnw
else
    print_error "Neither Maven nor Maven wrapper found. Please install Maven."
    exit 1
fi

print_status "Cleaning and compiling the project..."
$MVN_CMD clean compile -q

if [ $? -ne 0 ]; then
    print_error "Compilation failed. Please check the errors above."
    exit 1
fi

print_status "Starting the Attijariwafa Bank Transaction Processor..."
print_status "The application will be available at: http://localhost:8080"
print_status "H2 Database console will be available at: http://localhost:8080/h2-console"
print_status ""
print_status "Endpoints available:"
print_status "  - Main Interface: http://localhost:8080/"
print_status "  - Transaction Processor: http://localhost:8080/position/v2/transactionProcessor"
print_status "  - Signature Generator: http://localhost:8080/position/v2/generate-test-signature"
print_status ""
print_warning "Press Ctrl+C to stop the application"
print_status ""

# Start the Spring Boot application
$MVN_CMD spring-boot:run