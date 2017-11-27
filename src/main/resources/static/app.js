/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = (function () {
    return {
        getMessages: function () {
            $.get("/messages", function (data) {
                $("#msgs").append(data).append("<br/>");
            });
        }
    };
})();