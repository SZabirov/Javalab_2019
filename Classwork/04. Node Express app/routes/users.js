var express = require('express');
var router = express.Router();
var fs = require('fs');

router.get('/', function(req, res, next) {
  fs.readFile('users.txt', 'utf-8', function (err, data) {
    var dataByString = data.split('\n');
    var result = [];
    for (var i = 0; i < dataByString.length - 1; i++) {
      var elems = dataByString[i].split(' ');
      result.push({
        'firstname': elems[0],
        'secondname': elems[1]
      })
    }
    res.json(result);
  })
});

router.post('/', function(req, res, next) {
  var firstname = req.body.firstname;
  var secondname = req.body.secondname;
  fs.appendFile('users.txt',
      firstname + ' ' + secondname + '\n', function (err) {
        if(err) {
          console.log()
        }
      });
  res.redirect('users.html');
});

module.exports = router;
