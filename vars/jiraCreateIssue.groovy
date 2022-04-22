def call(Map config=[:]) {
  def rawBody = libraryResource 'com/planetpope/api/jira/createIssue.json'
  def binding = [
    key: "${jsonEvent(config.key)}",
    summary: "${jsonEvent(config.summary)}",
    description: "${jsonEvent(config.description)}",
    issueTypeName: "${jsonEvent(config.issueTypeName)}"
  ]
  def render = renderTemplate(rawBody,binding)
  println render
  //sh('curl -D- -u $JIRA_CREDENTIALS -X POST --data "'+render+'" -H "Content-Type: application/json" $JIRA_URL/rest/api/2/issue')
}
