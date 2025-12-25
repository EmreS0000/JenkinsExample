pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                sh '''
                javac -version
                cd src/test/java
                javac -cp /usr/share/java/junit4.jar com/example/HealthCheckTest.java
                java -cp /usr/share/java/junit4.jar:/usr/share/java/hamcrest-core.jar:. org.junit.runner.JUnitCore com.example.HealthCheckTest
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
