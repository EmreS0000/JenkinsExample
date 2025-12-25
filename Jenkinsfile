pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh '''
                javac -version
                javac -cp src/test/java src/main/java/com/example/HealthCheckMain.java src/test/java/com/example/HealthCheckTest.java
                java -cp src/main/java:src/test/java com.example.HealthCheckMain
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
