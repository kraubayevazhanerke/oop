package com.example.onlineshoppingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String homePage() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Online Shopping REST API</title>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <style>
                    body { 
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
                        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        min-height: 100vh;
                        padding: 20px;
                    }
                    .container { 
                        max-width: 1200px; 
                        margin: 0 auto; 
                        background: rgba(255, 255, 255, 0.95); 
                        padding: 40px; 
                        border-radius: 20px; 
                        box-shadow: 0 20px 60px rgba(0,0,0,0.3);
                    }
                    .header {
                        text-align: center;
                        padding-bottom: 30px;
                        border-bottom: 2px solid #eaeaea;
                        margin-bottom: 30px;
                    }
                    .header h1 { 
                        color: #2c3e50; 
                        font-size: 2.8em;
                        margin-bottom: 10px;
                    }
                    .badge {
                        display: inline-block;
                        padding: 5px 15px;
                        border-radius: 20px;
                        font-size: 0.9em;
                        font-weight: bold;
                        margin: 0 5px;
                        color: white;
                    }
                    .badge-spring { background: #6db33f; }
                    .badge-jpa { background: #00758f; }
                    .badge-postgres { background: #336791; }
                    .badge-rest { background: #ff6b6b; }
                    
                    .card { 
                        border: none; 
                        border-radius: 15px; 
                        transition: transform 0.3s; 
                        margin-bottom: 20px;
                    }
                    .card:hover { transform: translateY(-5px); }
                    
                    .endpoint { 
                        background: #f8f9fa; 
                        padding: 15px; 
                        border-radius: 10px; 
                        font-family: 'Courier New', monospace;
                        margin: 10px 0;
                        border-left: 4px solid #3498db;
                    }
                    
                    .method {
                        display: inline-block;
                        padding: 3px 10px;
                        border-radius: 5px;
                        font-weight: bold;
                        margin-right: 10px;
                        color: white;
                        font-size: 0.9em;
                    }
                    .method-get { background: #61affe; }
                    .method-post { background: #49cc90; }
                    .method-put { background: #fca130; }
                    .method-delete { background: #f93e3e; }
                    
                    .btn-custom {
                        margin: 5px;
                        padding: 10px 20px;
                        border-radius: 8px;
                        font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <h1>🛒 Online Shopping REST API</h1>
                        <p style="font-size: 1.2em; color: #555;">
                            Spring Boot REST API with PostgreSQL, JPA, and Validation
                        </p>
                        <div style="margin: 20px 0;">
                            <span class="badge badge-spring">Spring Boot 3.2.3</span>
                            <span class="badge badge-jpa">Spring Data JPA</span>
                            <span class="badge badge-postgres">PostgreSQL</span>
                            <span class="badge badge-rest">REST API</span>
                        </div>
                        <p style="color: #27ae60; font-weight: bold;">
                            ✅ API Status: Running on <a href="http://localhost:8080">http://localhost:8080</a>
                        </p>
                    </div>
                    
                    <!-- Quick Actions -->
                    <div class="row text-center mb-4">
                        <div class="col-md-3">
                            <a href="#products" class="btn btn-primary btn-custom w-100">📦 Products</a>
                        </div>
                        <div class="col-md-3">
                            <a href="#customers" class="btn btn-success btn-custom w-100">👥 Customers</a>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-info btn-custom w-100" onclick="testAllEndpoints()">🧪 Test API</button>
                        </div>
                        <div class="col-md-3">
                            <a href="https://github.com/kraubayevazhanerke/oop" class="btn btn-dark btn-custom w-100" target="_blank">📁 GitHub</a>
                        </div>
                    </div>
                    
                    <!-- Products Section -->
                    <div class="card" id="products">
                        <div class="card-header bg-primary text-white">
                            <h3 class="mb-0">📦 Product Management</h3>
                        </div>
                        <div class="card-body">
                            <!-- Add Product Form -->
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <h4>Add New Product</h4>
                                    <form id="productForm" onsubmit="return false;">
                                        <div class="mb-3">
                                            <input type="text" class="form-control" id="productName" placeholder="Product Name" required>
                                        </div>
                                        <div class="mb-3">
                                            <input type="number" step="0.01" class="form-control" id="productPrice" placeholder="Price ($)" required>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 mb-3">
                                                <input type="text" class="form-control" id="productCategory" placeholder="Category">
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <input type="number" class="form-control" id="productStock" placeholder="Stock Quantity" value="0">
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-success w-100" onclick="addProduct()">Add Product</button>
                                    </form>
                                </div>
                                <div class="col-md-6">
                                    <h4>Product Endpoints</h4>
                                    <div class="endpoint">
                                        <span class="method method-get">GET</span>
                                        <strong>/api/products</strong>
                                        <div style="color: #666; font-size: 0.9em;">Get all products</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-post">POST</span>
                                        <strong>/api/products</strong>
                                        <div style="color: #666; font-size: 0.9em;">Create new product</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-get">GET</span>
                                        <strong>/api/products/{id}</strong>
                                        <div style="color: #666; font-size: 0.9em;">Get product by ID</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-put">PUT</span>
                                        <strong>/api/products/{id}</strong>
                                        <div style="color: #666; font-size: 0.9em;">Update product</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-delete">DELETE</span>
                                        <strong>/api/products/{id}</strong>
                                        <div style="color: #666; font-size: 0.9em;">Delete product</div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Products Table -->
                            <h4>Products List</h4>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Category</th>
                                            <th>Stock</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody id="productsTable">
                                        <!-- Products will appear here -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Customers Section -->
                    <div class="card mt-4" id="customers">
                        <div class="card-header bg-success text-white">
                            <h3 class="mb-0">👥 Customer Management</h3>
                        </div>
                        <div class="card-body">
                            <!-- Add Customer Form -->
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <h4>Add New Customer</h4>
                                    <form id="customerForm" onsubmit="return false;">
                                        <div class="mb-3">
                                            <input type="text" class="form-control" id="firstName" placeholder="First Name" required>
                                        </div>
                                        <div class="mb-3">
                                            <input type="text" class="form-control" id="lastName" placeholder="Last Name" required>
                                        </div>
                                        <div class="mb-3">
                                            <input type="email" class="form-control" id="email" placeholder="Email" required>
                                        </div>
                                        <div class="mb-3">
                                            <input type="tel" class="form-control" id="phone" placeholder="Phone">
                                        </div>
                                        <button type="button" class="btn btn-success w-100" onclick="addCustomer()">Add Customer</button>
                                    </form>
                                </div>
                                <div class="col-md-6">
                                    <h4>Customer Endpoints</h4>
                                    <div class="endpoint">
                                        <span class="method method-get">GET</span>
                                        <strong>/api/customers</strong>
                                        <div style="color: #666; font-size: 0.9em;">Get all customers</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-post">POST</span>
                                        <strong>/api/customers</strong>
                                        <div style="color: #666; font-size: 0.9em;">Create new customer</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-get">GET</span>
                                        <strong>/api/customers/{id}</strong>
                                        <div style="color: #666; font-size: 0.9em;">Get customer by ID</div>
                                    </div>
                                    <div class="endpoint">
                                        <span class="method method-delete">DELETE</span>
                                        <strong>/api/customers/{id}</strong>
                                        <div style="color: #666; font-size: 0.9em;">Delete customer</div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Customers Table -->
                            <h4>Customers List</h4>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody id="customersList">
                                        <!-- Customers will appear here -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!-- API Testing -->
                    <div class="card mt-4">
                        <div class="card-header bg-info text-white">
                            <h3 class="mb-0">🧪 API Testing</h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h5>Test with curl:</h5>
                                    <pre style="background: #f5f5f5; padding: 15px; border-radius: 8px;">
# Get all products
curl http://localhost:8080/api/products

# Add product
curl -X POST http://localhost:8080/api/products \\
  -H "Content-Type: application/json" \\
  -d '{"name":"Laptop","price":999.99,"category":"Electronics","stockQuantity":10}'

# Get all customers
curl http://localhost:8080/api/customers
                                    </pre>
                                </div>
                                <div class="col-md-6">
                                    <h5>Quick Test</h5>
                                    <button class="btn btn-primary w-100 mb-2" onclick="loadProducts()">Test GET /api/products</button>
                                    <button class="btn btn-success w-100 mb-2" onclick="loadCustomers()">Test GET /api/customers</button>
                                    <div id="testResult" style="margin-top: 15px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="text-center mt-4" style="color: #666; font-size: 0.9em;">
                        <p>Online Shopping API • Spring Boot • PostgreSQL • REST</p>
                    </div>
                </div>
                
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
                <script>
                    const API_BASE = 'http://localhost:8080/api';
                    
                    // Load data on page load
                    document.addEventListener('DOMContentLoaded', function() {
                        loadProducts();
                        loadCustomers();
                    });
                    
                    // Product functions
                    async function loadProducts() {
                        try {
                            const response = await fetch(API_BASE + '/products');
                            const products = await response.json();
                            displayProducts(products);
                            showTestResult('✅ Products loaded successfully: ' + products.length + ' products');
                        } catch (error) {
                            showTestResult('❌ Error loading products: ' + error.message, 'error');
                        }
                    }
                    
                    function displayProducts(products) {
                        const table = document.getElementById('productsTable');
                        table.innerHTML = '';
                        
                        products.forEach(product => {
                            const row = `
                                <tr>
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>$${product.price ? product.price.toFixed(2) : '0.00'}</td>
                                    <td>${product.category || '-'}</td>
                                    <td>${product.stockQuantity || 0}</td>
                                    <td>
                                        <button class="btn btn-sm btn-warning" onclick="editProduct(${product.id})">Edit</button>
                                        <button class="btn btn-sm btn-danger" onclick="deleteProduct(${product.id})">Delete</button>
                                    </td>
                                </tr>
                            `;
                            table.innerHTML += row;
                        });
                    }
                    
                    async function addProduct() {
                        const product = {
                            name: document.getElementById('productName').value,
                            price: parseFloat(document.getElementById('productPrice').value),
                            category: document.getElementById('productCategory').value,
                            stockQuantity: parseInt(document.getElementById('productStock').value) || 0
                        };
                        
                        try {
                            const response = await fetch(API_BASE + '/products', {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify(product)
                            });
                            
                            if (response.ok) {
                                document.getElementById('productForm').reset();
                                loadProducts();
                                showTestResult('✅ Product added successfully');
                            } else {
                                const error = await response.text();
                                showTestResult('❌ Error: ' + error, 'error');
                            }
                        } catch (error) {
                            showTestResult('❌ Error: ' + error.message, 'error');
                        }
                    }
                    
                    // Customer functions
                    async function loadCustomers() {
                        try {
                            const response = await fetch(API_BASE + '/customers');
                            const customers = await response.json();
                            displayCustomers(customers);
                            showTestResult('✅ Customers loaded successfully: ' + customers.length + ' customers');
                        } catch (error) {
                            showTestResult('❌ Error loading customers: ' + error.message, 'error');
                        }
                    }
                    
                    function displayCustomers(customers) {
                                        const table = document.getElementById('customersList');
                                        table.innerHTML = '';
                
                                        customers.forEach(customer => {
                                            const row = `
                                                <tr>
                                                    <td>${customer.id}</td>
                                                    <td>${customer.name}</td>
                                                    <td>${customer.email}</td>
                                                    <td>${customer.address || '-'}</td>
                                                    <td>
                                                        <button class="btn btn-sm btn-danger" onclick="deleteCustomer(${customer.id})">Delete</button>
                                                    </td>
                                                </tr>
                                            `;
                                            table.innerHTML += row;
                                        });
                                    }
                    
                    async function addCustomer() {
                                        const firstName = document.getElementById('firstName').value;
                                        const lastName = document.getElementById('lastName').value;
                                        const email = document.getElementById('email').value;
                                        const phone = document.getElementById('phone').value;
                
                                        const customer = {
                                            name: firstName + " " + lastName,
                                            email: email,
                                            address: phone 
                                        };
                        
                        try {
                            const response = await fetch(API_BASE + '/customers', {
                                method: 'POST',
                                headers: { 'Content-Type': 'application/json' },
                                body: JSON.stringify(customer)
                            });
                            
                            if (response.ok) {
                                document.getElementById('customerForm').reset();
                                loadCustomers();
                                showTestResult('✅ Customer added successfully');
                            } else {
                                const error = await response.text();
                                showTestResult('❌ Error: ' + error, 'error');
                            }
                        } catch (error) {
                            showTestResult('❌ Error: ' + error.message, 'error');
                        }
                    }
                    
                    // Delete functions
                    async function deleteProduct(id) {
                        if (confirm('Delete this product?')) {
                            await fetch(API_BASE + '/products/' + id, { method: 'DELETE' });
                            loadProducts();
                        }
                    }
                    
                    async function deleteCustomer(id) {
                        if (confirm('Delete this customer?')) {
                            await fetch(API_BASE + '/customers/' + id, { method: 'DELETE' });
                            loadCustomers();
                        }
                    }
                    
                    // Test all endpoints
                    async function testAllEndpoints() {
                        showTestResult('🧪 Testing all endpoints...');
                        
                        try {
                            // Test products endpoint
                            const productsRes = await fetch(API_BASE + '/products');
                            const products = await productsRes.json();
                            
                            // Test customers endpoint
                            const customersRes = await fetch(API_BASE + '/customers');
                            const customers = await customersRes.json();
                            
                            showTestResult(`✅ All endpoints working! Products: ${products.length}, Customers: ${customers.length}`);
                        } catch (error) {
                            showTestResult('❌ API test failed: ' + error.message, 'error');
                        }
                    }
                    
                    function showTestResult(message, type = 'success') {
                        const resultDiv = document.getElementById('testResult');
                        resultDiv.innerHTML = message;
                        resultDiv.style.padding = '10px';
                        resultDiv.style.borderRadius = '5px';
                        resultDiv.style.marginTop = '10px';
                        
                        if (type === 'error') {
                            resultDiv.style.backgroundColor = '#f8d7da';
                            resultDiv.style.color = '#721c24';
                            resultDiv.style.border = '1px solid #f5c6cb';
                        } else {
                            resultDiv.style.backgroundColor = '#d4edda';
                            resultDiv.style.color = '#155724';
                            resultDiv.style.border = '1px solid #c3e6cb';
                        }
                    }
                </script>
            </body>
            </html>
            """;
    }
}