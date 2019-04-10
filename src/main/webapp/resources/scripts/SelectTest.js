$(document).ready(function() {

    var testsData;
    $(document).on('input','#topic', function (ev) {

        if ($(ev.target).val() == "") {
            $('.innerTestsDiv').remove();
            $('.innerQuestionsDiv').remove();
        }
        $.ajax({
            type : "GET",
            url : "/GetTestsByTopic",
            data : {
                targetTopic : $(ev.target).val()
            },
            success : function (data) {
                testsData = data;
                console.log(data);
                $('.tests').append('<div class="innerTestsDiv"><input type="text" required list="tests" placeholder="Введите новый или выберите тест" id="test" name="test" autocomplete="off">' +
                    '<input hidden id="testId" name="testId" value="">'+
                    '<datalist id="tests" class="testsDatalist">');

                data.forEach(function(test) {
                    $('.testsDatalist').append('<option>'+test.description+'</option>');
                });

                $('.tests').append('</datalist></div>');

            }
        })
    });

    $(document).on('input','#test', function (ev) {
        var s = $(ev.target).val();
        var testId;
        for (var j = 0; j < testsData.length; j++) {
            if (s == testsData[j].description) testId = testsData[j].testId;
        }
        document.getElementById('testId').value = testId;
    });

});


