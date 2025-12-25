pipeline {
    agent any

    stages {
        stage('Health Check') {
            steps {
                script {
                    def branch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: ''
                    def isMain = branch == 'main' || branch == 'origin/main' || branch == 'refs/heads/main'
                    def isTest = branch == 'test' || branch == 'origin/test' || branch == 'refs/heads/test'
                    def endpoint = isMain ? 'https://example.com' : (isTest ? 'https://httpbin.org/status/400' : 'https://example.com')
                    def expected = isMain ? '200' : (isTest ? '400' : '200')
                    def mvnCmd = "mvn -B -DskipTests=false -DendpointUrl=${endpoint} -DexpectedStatus=${expected} test"
                    if (isUnix()) {
                        sh mvnCmd
                    } else {
                        bat mvnCmd
                    }
                    junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def branch = env.BRANCH_NAME ?: env.GIT_BRANCH ?: ''
                    def isMain = branch == 'main' || branch == 'origin/main' || branch == 'refs/heads/main'
                    if (isMain) {
                        echo "Deploying application..."
                        echo "Deploy successful!"
                    } else {
                        echo "Skipping Deploy on branch: ${branch}"
                    }
                }
            }
        }
    }
}
