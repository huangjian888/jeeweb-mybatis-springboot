$(function () {
    var wizard_1 = $("#wizard-1").steps({
        transitionEffect: "slideLeft"
    });
    wizard_1.steps("add", {
        title: "Account",
        content: '<fieldset><legend>Account Information</legend><div class="form-group"><label for="userName">User name *</label><div><input id="userName" name="userName" type="text" class="form-control required"></div></div><div class="form-group"><label for="password">Password *</label><div><input id="password" name="password" type="text" class="form-control required"></div></div><div class="form-group"><label for="confirm">Confirm Password *</label><div><input id="confirm" name="confirm" type="text" class="form-control required"></div></div></fieldset>'
    });
    wizard_1.steps("add", {
        title: "Profile",
        content: '<fieldset><legend>Profile Information</legend><div class="form-group"><label for="name">First name *</label><div><input id="name" name="name" type="text" class="form-control required"></div></div><div class="form-group"><label for="surname">Last name *</label><div><input id="surname" name="surname" type="text" class="form-control required"></div></div><div class="form-group"><label for="email">Email *</label><div><input id="email" name="email" type="text" class="form-control required email"></div></div><div class="form-group"><label for="address">Address</label><div><input id="address" name="address" type="text" class="form-control"></div></div><div class="form-group"><label for="age">Age (The warning step will show up if age is less than 18) *</label><div><input id="age" name="age" type="text" class="form-control required number"></div></div></fieldset>'
    });
    wizard_1.steps("add", {
        title: "Warning",
        content: '<fieldset><legend>You are to young</legend><p>Please go away ;-)</p></fieldset>'
    });
    wizard_1.steps("add", {
        title: "Finish",
        content: '<fieldset><legend>Terms and Conditions</legend><input id="acceptTerms" name="acceptTerms" type="checkbox" class="required"> <label for="acceptTerms">I agree with the Terms and Conditions.</label></fieldset>'
    });

    $("#form-2").validate({
        rules: {
            userName: {
                required: true
            },
            password: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            confirm: {
                required: true,
                minlength: 3,
                maxlength: 20,
                equalTo: '#password'
            }
        },
        messages: {
            userName:
            {
                required: 'Please enter your userName'
            },
            password:
            {
                required: 'Please enter your password'
            },
            confirm: {
                equalTo: "#password"
            }
        },
        errorPlacement: function(error, element)
        {
            error.insertAfter(element.parent());
        }
    });
    var wizard_2 = $("#wizard-2").steps({
        transitionEffect: "slideLeft",
        onStepChanging: function (event, currentIndex, newIndex)
        {
            $("#form-2").validate().settings.ignore = ":disabled,:hidden";
            return $("#form-2").valid();
        },
        onFinishing: function (event, currentIndex)
        {
            $("#form-2").validate().settings.ignore = ":disabled";
            return $("#form-2").valid();
        },
        onFinished: function (event, currentIndex)
        {
            alert("Submitted!");
        }
    });
    wizard_2.steps("add", {
        title: "Account",
        content: '<fieldset><legend>Account Information</legend><div class="form-group"><label for="userName">User name *</label><div><input id="userName" name="userName" type="text" class="form-control required"></div></div><div class="form-group"><label for="password">Password *</label><div><input id="password" name="password" type="text" class="form-control required"></div></div><div class="form-group"><label for="confirm">Confirm Password *</label><div><input id="confirm" name="confirm" type="text" class="form-control required"></div></div></fieldset>'
    });
    wizard_2.steps("add", {
        title: "Profile",
        content: '<fieldset><legend>Profile Information</legend><div class="form-group"><label for="name">First name *</label><div><input id="name" name="name" type="text" class="form-control required"></div></div><div class="form-group"><label for="surname">Last name *</label><div><input id="surname" name="surname" type="text" class="form-control required"></div></div><div class="form-group"><label for="email">Email *</label><div><input id="email" name="email" type="text" class="form-control required email"></div></div><div class="form-group"><label for="address">Address</label><div><input id="address" name="address" type="text" class="form-control"></div></div><div class="form-group"><label for="age">Age (The warning step will show up if age is less than 18) *</label><div><input id="age" name="age" type="text" class="form-control required number"></div></div></fieldset>'
    });
    wizard_2.steps("add", {
        title: "Warning",
        content: '<fieldset><legend>You are to young</legend><p>Please go away ;-)</p></fieldset>'
    });
    wizard_2.steps("add", {
        title: "Finish",
        content: '<fieldset><legend>Terms and Conditions</legend><input id="acceptTerms" name="acceptTerms" type="checkbox" class="required"> <label for="acceptTerms">I agree with the Terms and Conditions.</label></fieldset>'
    });

    $("#form-3").validate({
        rules: {
            userName1: {
                required: true
            },
            password1: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            confirm1: {
                required: true,
                minlength: 3,
                maxlength: 20,
                equalTo: '#password1'
            }
        },
        messages: {
            userName1:
            {
                required: 'Please enter your userName'
            },
            password1:
            {
                required: 'Please enter your password'
            },
            confirm1: {
                equalTo: "#password1"
            }
        },
        errorPlacement: function(error, element)
        {
            error.insertAfter(element.parent());
        }
    });
    var wizard_3 = $("#wizard-3").steps({
        transitionEffect: "slideLeft",
        stepsOrientation: "vertical",
        onStepChanging: function (event, currentIndex, newIndex)
        {
            $("#form-3").validate().settings.ignore = ":disabled,:hidden";
            return $("#form-3").valid();
        },
        onFinishing: function (event, currentIndex)
        {
            $("#form-3").validate().settings.ignore = ":disabled";
            return $("#form-3").valid();
        },
        onFinished: function (event, currentIndex)
        {
            alert("Submitted!");
        }
    });
    wizard_3.steps("add", {
        title: "Account",
        content: '<fieldset><legend>Account Information</legend><div class="form-group"><label for="userName1">User name *</label><div><input id="userName1" name="userName1" type="text" class="form-control required"></div></div><div class="form-group"><label for="password1">Password *</label><div><input id="password1" name="password1" type="text" class="form-control required"></div></div><div class="form-group"><label for="confirm1">Confirm Password *</label><div><input id="confirm1" name="confirm1" type="text" class="form-control required"></div></div></fieldset>'
    });
    wizard_3.steps("add", {
        title: "Profile",
        content: '<fieldset><legend>Profile Information</legend><div class="form-group"><label for="name1">First name *</label><div><input id="name1" name="name1" type="text" class="form-control required"></div></div><div class="form-group"><label for="surname1">Last name *</label><div><input id="surname1" name="surname1" type="text" class="form-control required"></div></div><div class="form-group"><label for="email1">Email *</label><div><input id="email1" name="email1" type="text" class="form-control required email"></div></div><div class="form-group"><label for="address1">Address</label><div><input id="address1" name="address1" type="text" class="form-control"></div></div><div class="form-group"><label for="age1">Age (The warning step will show up if age is less than 18) *</label><div><input id="age1" name="age1" type="text" class="form-control required number"></div></div></fieldset>'
    });
    wizard_3.steps("add", {
        title: "Warning",
        content: '<fieldset><legend>You are to young</legend><p>Please go away ;-)</p></fieldset>'
    });
    wizard_3.steps("add", {
        title: "Finish",
        content: '<fieldset><legend>Terms and Conditions</legend><input id="acceptTerms1" name="acceptTerms1" type="checkbox" class="required"> <label for="acceptTerms1">I agree with the Terms and Conditions.</label></fieldset>'
    });

    var wizard_4 = $("#wizard-4").steps({
        transitionEffect: "slide"
    });
    wizard_4.steps("add", {
        title: "Async Step",
        contentMode: "async",
        contentUrl: "/vendors/jquery-steps/data/AsyncContent.html"
    });
    wizard_4.steps("add", {
        title: "Second Step",
        content: '<section><p>Donec mi sapien, hendrerit nec egestas a, rutrum vitae dolor. Nullam venenatis diam ac ligula elementum pellentesque. In lobortis sollicitudin felis non eleifend. Morbi tristique tellus est, sed tempor elit. Morbi varius, nulla quis condimentum dictum, nisi elit condimentum magna, nec venenatis urna quam in nisi. Integer hendrerit sapien a diam adipiscing consectetur. In euismod augue ullamcorper leo dignissim quis elementum arcu porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum leo velit, blandit ac tempor nec, ultrices id diam. Donec metus lacus, rhoncus sagittis iaculis nec, malesuada a diam.Donec non pulvinar urna. Aliquam id velit lacus.</p></section>'
    });
    wizard_4.steps("add", {
        title: "Third Step",
        content: '<section><p>Morbi ornare tellus at elit ultrices id dignissim lorem elementum. Sed eget nisl at justo condimentum dapibus. Fusce eros justo, pellentesque non euismod ac, rutrum sed quam. Ut non mi tortor. Vestibulum eleifend varius ullamcorper. Aliquam erat volutpat. Donec diam massa, porta vel dictum sit amet, iaculis ac massa. Sed elementum dui commodo lectus sollicitudin in auctor mauris venenatis.</p></section>'
    });
    wizard_4.steps("add", {
        title: "Forth Step",
        content: '<section><p>Quisque at sem turpis, id sagittis diam. Suspendisse malesuada eros posuere mauris vehicula vulputate. Aliquam sed sem tortor. Quisque sed felis ut mauris feugiat iaculis nec ac lectus. Sed consequat vestibulum purus, imperdiet varius est pellentesque vitae. Suspendisse consequat cursus eros, vitae tempus enim euismod non. Nullam ut commodo tortor.</p></section>'
    });

    /*************************************************/
    /************ #rootwizard-custom-arrow ***********/
    $('#rootwizard-tabdetail2').bootstrapWizard({
        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index+1;
            var $percent = ($current/$total) * 100;
            $('#rootwizard-tabdetail2').find('.bar').css({width:$percent+'%'});
        },
        'onNext': function(tab, navigation, index) {

            // select id of current tab content
            var $id = tab.find("a").attr("href");
            var $approved = 1;
            // Check all input validation
            $($id + " input").each(function(){
                if (!$(this).val()) {
                    $(this).parent().parent().find("i.alert").removeClass("alert-hide");
                    $approved = 0;
                } else {
                    $(this).parent().parent().find("i.alert").addClass("alert-hide");
                }
            });
            if ($approved !== 1) return false;
        },
        'onTabClick': function(tab, navigation, index) {
            // select id of current tab content
            var $id = tab.find("a").attr("href");
            var $approved = 1;
            // Check all input validation
            $($id + " input").each(function(){
                if (!$(this).val()) {
                    $(this).parent().parent().find("i.alert").removeClass("alert-hide");
                    $approved = 0;
                } else {
                    $(this).parent().parent().find("i.alert").addClass("alert-hide");
                }
            });
            if ($approved !== 1) return false;
            // Add class visited to style css
            if (tab.attr("class")=="visited"){
                tab.removeClass("visited");
            } else {
                tab.addClass("visited");
            }
        },'tabClass': 'nav nav-pills','nextSelector': '.button-next', 'previousSelector': '.button-previous'
    });
    /************ #rootwizard-custom-circle ***********/
    $('#rootwizard-custom-circle').bootstrapWizard({
        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index+1;
            var $percent = ($current/$total) * 100;
            $('#rootwizard-custom-circle').find('.bar').css({width:$percent+'%'});
        },
        'onNext': function(tab, navigation, index) {

            // select id of current tab content
            var $id = tab.find("a").attr("href");
            var $approved = 1;
            // Check all input validation
            $($id + " input").each(function(){
                if (!$(this).val()) {
                    $(this).css('border-color', 'red');
                    $(this).parent().parent().find("i.alert").removeClass("alert-hide");
                    $approved = 0;
                } else {
                    $(this).parent().parent().find("i.alert").addClass("alert-hide");
                }
            });
            if ($approved !== 1) return false;
        },
        'onTabClick': function(tab, navigation, index) {
            // select id of current tab content
            var $id = tab.find("a").attr("href");
            var $approved = 1;
            // Check all input validation
            $($id + " input").each(function(){
                if (!$(this).val()) {
                    $(this).css('border-color', 'red');
                    $(this).parent().parent().find("i.alert").removeClass("alert-hide");
                    $approved = 0;
                } else {
                    $(this).parent().parent().find("i.alert").addClass("alert-hide");
                }
            });
            if ($approved !== 1) return false;
            // Add class visited to style css
            if (tab.attr("class")=="visited"){
                tab.removeClass("visited");
            } else {
                tab.addClass("visited");
            }
        },
        'tabClass': 'bwizard-steps-o','nextSelector': '.button-next', 'previousSelector': '.button-previous'
    });

});