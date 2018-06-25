$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/cheeseCategories.feature");
formatter.feature({
  "line": 2,
  "name": "Cheese Categories",
  "description": "",
  "id": "cheese-categories",
  "keyword": "Feature"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "I am on the Cheesessquare app category page and \"Cheesesquare\" is displayed",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Cheesesquare",
      "offset": 49
    }
  ],
  "location": "CheeseCategoriesStepDef.i_am_on_the_Cheesessquare_app_category_page_and_is_displayed(String)"
});
formatter.result({
  "duration": 10341161330,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Check if all the 3 categories of cheese are displayed",
  "description": "",
  "id": "cheese-categories;check-if-all-the-3-categories-of-cheese-are-displayed",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@test1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "the below categories should be displayed",
  "rows": [
    {
      "cells": [
        "CATEGORY 1"
      ],
      "line": 12
    },
    {
      "cells": [
        "CATEGORY 2"
      ],
      "line": 13
    },
    {
      "cells": [
        "CATEGORY 3"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "CheeseCategoriesStepDef.the_below_categories_should_be_displayed(String\u003e)"
});
formatter.result({
  "duration": 5823840949,
  "status": "passed"
});
});