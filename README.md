![GSI Logo](http://gsi.dit.upm.es/templates/jgsi/images/logo.png)
[Grupo Sistemas Inteligentes](http://gsi.dit.upm.es) 
==================================

Getting started
---------------------
Mock server that provides default responses for testing and demonstration purposes.

Launch the application and proceed to the url [localhost:8080/gsibot-mock-server/talktobot](http://localhost:8080/gsibot-mock-server/talktobot)

Response formats
----------------------------

Since the browser accepts "text/html" it shows the html response. Depending on content of the **Accept** header the response is formated in XML, Html or Json.

### Xml Format

With **Accept: text/xml;** or **Accept: application/xml;**.

    <?xml version="1.0" encoding="UTF-8"?>
    <dialog>
        <userid>the_user_id_or_session_id_with_non_authentication_services</userid>
        <bot>Erika</bot>
        <q>hola</q>
        <response>The response to the question given</response>
        <mood>Happy</mood>
        <test>dummy-test-value</test>
        <url>https://github.com/miguelcb84/gsibot-testserver</url>
    </dialog>

### Json Format

With **Accept: application/json;**.

    {
      "diaglog": {
          "userid": "Userid here",
          "bot": "Erika",
          "q": "hola",
          "response": "The username or the session id",
          "mood": "The mood of the bot (optional)",
          "url": "Redirecting url (optional)",
          "test": "Unique response for testing purposes (optional)"
      }
    }

### Html Format

With **Accept: text/html;** or **Accept: text/plain;**.

    <!DOCTYPE html>
    <html>
        <head>
            <title>GsiBot Server Mock v1.0</title>
        </head>
        <body>
            <p>Userid:</p>
            <p id="userid">The username</p>
            <p>Bot:</p>
            <p id="bot">Erika</p>
            <p>Question:</p>
            <p id="q">hola</p>
            <p>Response:</p>
            <p id="response">The response of the bot</p>
        </body>
    </html>


