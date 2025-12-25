pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh '''
                javac -version
                cd src/test/java
                javac com/example/HealthCheckTest.java
                java -cp . com.example.HealthCheckTest
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy çalışıyor..."
            }
        }
    }
}
