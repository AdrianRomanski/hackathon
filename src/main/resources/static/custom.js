//= require jquery


//navigation
var linkClicked = document.getElementsByClassName('nav-link');
var numClass = linkClicked.length;

for (var i = 0; i < numClass; i++) {
    linkClicked[i].addEventListener('click', function(){
        var onTheMoment = document.getElementsByClassName('active');
        onTheMoment[0].className = onTheMoment[0].className.replace(' active', '');
        this.className += ' active';
    }, false);
}

// navigation button
$(document).ready(function() {
    $('.nav-button').click(function () {
        $('.nav-button').toggleClass('change');
    });

// moving navigation
    $(window).scroll(function () {
        let position = $(this).scrollTop();
        if (position >= 200) {
            $('.nav-menu').addClass('custom-navbar');
        } else {
            $('.nav-menu').removeClass('custom-navbar');
        }
    });


// mission
    $(window).scroll(function () {
        let position = $(this).scrollTop();
        if (position >= 600) {
            $('.camera-img').addClass('fromLeft');
            $('.mission-text').addClass('fromRight');
        } else {
            $('.camera-img').removeClass('fromLeft');
            $('.mission-text').removeClass('fromRight');
        }
    })

//products
    $(window).scroll(function () {
        let position = $(this).scrollTop();
        console.log(position)

        // if(position >= 35) {
        //     $('.cosmetic-1-name-anim').addClass('fromLeftCosmetics');
        // } else {
        //     $('.cosmetic-1-name-anim').removeClass('fromLeftCosmetics').addClass('testing-anim-2');
        // }

        // if(position >= 150) {
        //     $('.cosmetic-1-text-anim').addClass('fromBottomCosmetics');
        // } else {
        //     $('.cosmetic-1-text-anim').removeClass('fromBottomCosmetics').addClass('testing-anim-2');
        // }

        if (position >= 200) {
            $('.cosmetic-2-name-anim').addClass('fromRightCosmetics');
        } else {
            $('.cosmetic-2-name-anim').removeClass('fromRightCosmetics');
        }
        if(position >= 275) {
            $('.cosmetic-2-text-anim').addClass('fromBottomCosmetics');
        } else {
            $('.cosmetic-2-text-anim').removeClass('fromBottomCosmetics').addClass('testing-anim-2');
        }
    });

});


