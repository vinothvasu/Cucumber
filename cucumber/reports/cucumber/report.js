$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featureFiles/dryRun.feature");
formatter.feature({
  "name": "Login DataSet",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Positive Login LeafTaps",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter the UserName as \u003cusername\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Enter the Password as \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "Check Submit button is displayed",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Login",
  "keyword": "When "
});
formatter.step({
  "name": "Verify Login is Successful",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "DemoSalesManager",
        "crmsfa"
      ]
    },
    {
      "cells": [
        "DemoCSR",
        "crmsfa"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open the Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.invokeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Maximize the window",
  "keyword": "And "
});
formatter.match({
  "location": "Login.maximizeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Load the URL",
  "keyword": "And "
});
formatter.match({
  "location": "Login.loadURL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the TimeOut",
  "keyword": "And "
});
formatter.match({
  "location": "Login.setTimeOut()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Positive Login LeafTaps",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter the UserName as DemoSalesManager",
  "keyword": "And "
});
formatter.match({
  "location": "Login.userName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the Password as crmsfa",
  "keyword": "And "
});
formatter.match({
  "location": "Login.password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check Submit button is displayed",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "When "
});
formatter.match({
  "location": "Login.login()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify Login is Successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.verifyLogin()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open the Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.invokeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Maximize the window",
  "keyword": "And "
});
formatter.match({
  "location": "Login.maximizeBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Load the URL",
  "keyword": "And "
});
formatter.match({
  "location": "Login.loadURL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Set the TimeOut",
  "keyword": "And "
});
formatter.match({
  "location": "Login.setTimeOut()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Positive Login LeafTaps",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter the UserName as DemoCSR",
  "keyword": "And "
});
formatter.match({
  "location": "Login.userName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the Password as crmsfa",
  "keyword": "And "
});
formatter.match({
  "location": "Login.password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check Submit button is displayed",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "When "
});
formatter.match({
  "location": "Login.login()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify Login is Successful",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.verifyLogin()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});