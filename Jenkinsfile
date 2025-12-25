pipeline {
    agent any

    stages {
        stage('Health Check') {
            when {
                branch 'main'
            }
            steps {
                sh '''
                javac -version
                javac src/test/java/com/example/HealthCheckTest.java
                java -cp src/test/java com.example.HealthCheckTest
                '''
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying application..."
                echo "Deploy successful!"
            }
        }
    }
}
