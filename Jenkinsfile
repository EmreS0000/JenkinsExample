pipeline {
    agent any
    
    tools {
        maven 'Maven 3.8.6' // Jenkins'te tanımlı Maven kurulumu adı
    }
    
    stages {
        stage('Build & Compile') {
            steps {
                echo 'Compiling Java project...'
                bat 'mvn clean compile'
            }
        }
        
        stage('Run JUnit Health Check Tests') {
            steps {
                echo '================================'
                echo 'Running JUnit tests...'
                echo 'Test will send GET request to https://example.com'
                echo '- Status 200: Test passes → Deploy'
                echo '- Status 400/500: Test fails → No deploy'
                echo '- Connection error: Test fails → No deploy'
                echo '================================'
                
                script {
                    try {
                        // JUnit testlerini çalıştır (HealthCheckTest.java)
                        bat 'mvn test'
                        env.TESTS_PASSED = 'true'
                        echo '✓ All JUnit tests passed!'
                    } catch (Exception e) {
                        env.TESTS_PASSED = 'false'
                        echo "✗ JUnit tests failed: ${e.message}"
                        error("Health check failed - Pipeline stopped")
                    }
                }
            }
            post {
                always {
                    // JUnit test raporlarını Jenkins'e yükle
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Deploy Application') {
            when {
                expression { env.TESTS_PASSED == 'true' }
            }
            steps {
                echo '================================'
                echo '✓ Health check successful!'
                echo '✓ Deploying application...'
                echo '================================'
                
                // Deployment komutlarınızı buraya ekleyin:
                // bat 'deploy.bat'
                // bat 'kubectl apply -f deployment.yaml'
                // bat 'docker push myapp:latest'
                
                echo 'Deployment completed successfully!'
            }
        }
    }
    
    post {
        success {
            echo '================================'
            echo '✓ Pipeline completed successfully!'
            echo '✓ Health check passed'
            echo '✓ Deployment successful'
            echo '================================'
        }
        failure {
            echo '================================'
            echo '✗ Pipeline failed!'
            echo '✗ Check JUnit test results for details'
            echo '================================'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}
