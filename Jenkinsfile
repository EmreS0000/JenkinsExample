pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh '''
                javac -version
                cd src/test/java
                javac com/example/HealthCheckTest.java com/example/HealthCheckMain.java
                java -cp . com.example.HealthCheckMain
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
