node {
  ansiColor('xterm') {

  }
  timestamps {

  }
  stage('1 - Get Code') {
    git credentialsId: 'hoang_mvn_framework', url: 'https://github.com/hoanglk12/maven-hybrid-framework-bankguru.git'
  }
  stage('2 - Compile') {
    bat label: 'Compile Source Code', script: 'mvn clean'
  }
  stage('3 - Run Test') {
    bat label: 'Run Test on testing environment', script: 'mvn test -DenvMaven=testing'
  }
  stage('4 - Public Report') {
    publishHTML([
      allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: false,
      reportDir: 'C:\\Users\\hoangrvp12\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\MAVEN_JAVA_FRAMEWORK_BANKGURU_PIPELINE\\target\\surefire-reports\\html',
      reportFiles: 'index.html',
      reportName: 'BANKGURU99 REPORTNG HTML',
      reportTitles: ''
    ])
  }
}