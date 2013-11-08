/// <reference path="jquery-1.7.1.min.js" />

//State for knowing if we display desktop or tablet size...
var state = null;

//List of functions to call when the resize event is triggered.
var resizeCallbacks = $.Callbacks();

////////////////////////////////////////////////////
// Document ready
////////////////////////////////////////////////////

//Document ready
$(document).ready(function () {
    //Caclulate menu info...
    menuInfo.Init();
    searchBlocks.Init();


    //Add functions to the list of callbacks...
    resizeCallbacks.add(ShowHideDropDownMenu);
    resizeCallbacks.add(SetLeftColumnToBottom);
    resizeCallbacks.add(menuInfo.OnResize);
    resizeCallbacks.add(searchBlocks.OnResize);
    resizeCallbacks.add(moveCalendar);
    resizeCallbacks.add(MoveSuLogo);
    resizeCallbacks.add(SwitchLeftAndMainSectionsForStartB);

    //Create a dropdown menu from the regular menu (to avoid duplicated code)
    createDropDownFromRegularMenu();

    resizeCallbacks.fire();

    $(window).resize(function () {
        resizeCallbacks.fire();
    });

});

//////////////////////////////////////////////////////////////////
// Switch positions for the left column and the main column to
// make the left column appear under the main column.
//////////////////////////////////////////////////////////////////
//TODO: See if we can do this without javascript.
var SwitchLeftAndMainSectionsForStartB = function () {
    if ($('body').hasClass('start_b')) { // Only for start_b
        if ($("body").width() <= 600) {
          $("#left-column").insertAfter("#main-news");
        }
        else {
            $("#main-news").insertAfter("#left-column");
        }
    }
};


//////////////////////////////////////////////////////////////////
// Move the Su logo on top of the department name
//////////////////////////////////////////////////////////////////
//TODO: See if we can do this without javascript.
var MoveSuLogo = function () {
    if ($("body").width() <= 660) {
      $(".head-left").insertAfter($(".head-right"));
      $(".head-right").css("float", "left");
    }
    else {
      $(".head-right").insertAfter($(".head-left"));
      $(".head-right").css("float", "right");
    }
};


//////////////////////////////////////////////////////////////////
// Aligns the menu to the bottom
//////////////////////////////////////////////////////////////////
var SetLeftColumnToBottom = function () {
    if ($("body").width() <= 700) {
        //Set a offset to get a better look
        var bottom = 14;

        //Only add height if the element was found.
        var topLinksHeight = $('.top-links-320 > .top-links').height();

        if (topLinksHeight !== null)
            bottom += topLinksHeight;
        var footerHeight = $('.footer').height();

        if (footerHeight !== null)
            bottom += footerHeight;
        //Move element...

        $('.left-column').css('bottom', bottom + 'px');

        bottom = $('.left-column').height();
        //Move object with class main-column so that the menu does not cover it.
       $(".main-column").css('padding-bottom', bottom + 'px');
    }
    else {
        $(".main-column").css('padding-bottom', '0px');
    }
};

//////////////////////////////////////////////////////////////////
// Moves the calendar below the carousel (and back if needed)
//////////////////////////////////////////////////////////////////
var calenderParent = null;
var indexInParent = -1;

var moveCalendar = function () {

    if ($('body').hasClass('start_b')) {
        if (calenderParent == null) {
            indexInParent = $('.calendar-col').parent().children().index($('.calendar-col'));
            calenderParent = $('.calendar-col').parent();
        }

        //Only move if width is smaller than 615 and current state is tablet (or the state is null = just entered page)
        if ($("body").width() <= 615 && (state === 'tablet' || state === null)) {
            state = 'phone'

            if ($('.calendar-col').length === 1)
                $('.calendar-col').insertAfter('.carouselWrapper');

        }
        //Only move if width larger than 615 and current state is phone (or the state is null = just entered page)
        if ($("body").width() > 615 && (state === 'phone' || state === null)) {
            state = 'tablet';
            if ($('.calendar-col').length === 1) {
                $('.calendar-col').insertBefore(calenderParent.children().get(indexInParent));
            }
        }
    }
}

//////////////////////////////////////////////////////////////////
// Hides/Shows the dynamically created dropdown and regular menu.
//////////////////////////////////////////////////////////////////
var ShowHideDropDownMenu = function () {
    //Tablet or Desktop? Only check if state has changed
    if ($("body").width() <= 660 && (state === 'desktop' || state === null)) {
        state = 'tablet';
        $('#HeadRowMenu').hide();
        $('.head-row-right').hide();
        $('.nav320Wrapper').show();
    }
    if ($("body").width() > 660 && (state === 'tablet' || state === null)) {
        state = 'desktop';
        $('#HeadRowMenu').show();
        $('.head-row-right').show();
        $('.nav320Wrapper').hide();
    }
};

//////////////////////////////////////////////////////////////////
// Creates a dropdown from the regular menu,
// to be showed in smaller width...
// The HTML created reflects the dropdown menu from the POC.
//////////////////////////////////////////////////////////////////
var createDropDownFromRegularMenu = function () {

    //Build some markup with the correct classes, id´s etc...

    var searchForm = document.getElementById('FormHeadSearch');
    var searchLink = searchForm? searchForm.getAttribute('action'): "javascript:nop"; // fallback (for not breaking everything)
    var searchSubmit = document.getElementById('BtnHeadSearch');
    var searchSubmitText = searchSubmit? searchSubmit.getAttribute('value') : ""; // fallback (for not breaking everything)
    var startLink = document.getElementById('startLinkId');
    var startLinkPath = startLink? startLink.getAttribute('href') : "javascript:nop"; // fallback (for not breaking everything)

    var nav320Wrapper = $('<div>').addClass('nav320Wrapper');
    var nav320WrapperInner = $('<div>').addClass('nav320WrapperInner');
    var nav320Home = $('<div>').addClass('link-wrapper-nav320').append($('<a href='+startLinkPath+'>').addClass('home-link').append('<span>'));
    var nav320Search = $('<div>').addClass('link-wrapper-nav320 search-link').append($('<a href='+searchLink+'>').append('<span>').text(searchSubmitText));
    var jumpWrapper = $('<div>').addClass('jumpWrapper');
    var select = $('<select>').addClass('jump').attr('name', 'jumpMenu').attr('id', 'jumpMenu');
    var form = $('<form>').attr('id', 'form').attr('action', '').attr('name', 'form');

    //Build them in the correct order
    nav320Wrapper.append(nav320WrapperInner);
    nav320WrapperInner.append(form);
    form.append(nav320Home).append(jumpWrapper).append(nav320Search);
    jumpWrapper.append(select);

    //Transform the menu into a dropdown
    var menuitems = $('#HeadRowMenu > li');
    var menuOption = $('<option>').attr('value', '#').text('Meny');
    select.append(menuOption);
    $.each(menuitems, function (ix, val) {
        var href = $('a', menuitems[ix]).attr('href');
        var active = $(menuitems[ix]).hasClass('active');
        var text = $(menuitems[ix]).text();

        var option = $('<option>').attr('value', href).text(text);
        if (active){
            option.addClass('selected');
            option.attr('selected', 'selected');
        }
        select.append(option);
    });

    //When the ménu is changed, navigate to the selection...
    select.change(function () {
        window.location = $(this).val();
    });
    //Insert the menu at the correct location in the page.
    nav320Wrapper.insertAfter($(".head-row"));

    // If chrome then disable webkit-appearance SUPP9-1822
    if(navigator.userAgent.toLowerCase().indexOf('chrome') > -1){
       $('jumpMenu').css("-webkit-appearance", "none");
    }

};

var searchBlocks = (function () {
    var _private = {

        active: false,
        eventsOn: false,

        Init: function () {
            if ($(".content-block .search-result").length > 0) {
                this.active = true;
                $(".content-block .search-result").parents(".content-block").addClass("active-search-result-block");
                $(".search-overview").parents(".content-block").addClass("active-search-result-block");
            } else {

            }
        },

        OnResize: function () {

            if (this.active) {
                if ($("body").width() <= 600) {
                    if (this.eventsOn == false) {

                        $(".active-search-result-block h2").click(function () {
                            $(this).parent().find(".content-block-inner").toggle();
                            $(this).parent().find(".content-block-link.link-left").toggle();
                        });

                        $(".active-search-result-block .content-block-inner").hide();
                        $(".active-search-result-block .content-block-link").hide();
                        this.eventsOn = true;
                    }
                } else {

                    if (this.eventsOn) {
                        $(".active-search-result-block h2").unbind("click");
                        $(".active-search-result-block .content-block-inner").show();
                        $(".active-search-result-block .content-block-link").show();
                        this.eventsOn = false;
                    }
                }
            }
        }

    };
    return {
        Init: function () { _private.Init(); },
        OnResize: function () { _private.OnResize(); }
    };
})();

//////////////////////////////////////////////////////////////////
// Menu... under development!
//////////////////////////////////////////////////////////////////

var lockHandler = function(event){
    event.preventDefault();
}

var menuInfo = (function () {
    var _private = {

        //INTERNA VARIABLER
        containerWidth: 0,
        maxNegMargin: 0,
        parentContainerWidth: 0,

        targetList: null,

        active: false,
        eventsOn: false,
        touchOffsetX: 0,

        moveRight: function (speed) {

            var currentPosition = parseInt(this.targetList.css("left").replace("px", ""));
            currentPosition -= speed;

            if (currentPosition <= this.maxNegMargin) {
                currentPosition = this.maxNegMargin;
                $("div.arrowButton.next").addClass("disabled");
            }

            $("div.arrowButton.back").removeClass("disabled");

            this.targetList.css("left", currentPosition + "px");
        },

        moveLeft: function (speed) {

            var currentPosition = parseInt(this.targetList.css("left").replace("px", ""));
            currentPosition += speed;

            if (currentPosition >= 0) {
                currentPosition = 0;
                $("div.arrowButton.back").addClass("disabled");
            }

            $("div.arrowButton.next").removeClass("disabled");

            this.targetList.css("left", currentPosition + "px");
        },

        initializeCarousel: function () {

            //HÄMTA REFERENSER
            this.targetList = $(".content-block.shortcuts.carousel .content-block-inner ul.block-user-groups");
        },

        calculateWidth: function () {
            //CALCULATE WIDTH
            var tmpWidth = 0;
            this.targetList.find("li").each(function () {
                tmpWidth += $(this).outerWidth(true) + 1;
            });

            this.containerWidth = tmpWidth;
            this.targetList.css("width", this.containerWidth + "px");

            this.parentContainerWidth = this.targetList.parent().width();
        },

        restorePositions: function () {
            this.targetList.css("left", "0px");
            $("div.arrowButton.back").addClass("disabled");
            $("div.arrowButton.next").removeClass("disabled");
        },

        registerEvents: function () {

            //CLICK EVENTS
            $("div.arrowButton.next").click(function (e) {
                e.preventDefault();
                menuInfo.MoveRight(10);
            });

            $("div.arrowButton.back").click(function (e) {
                e.preventDefault();
                menuInfo.MoveLeft(10);
            });

            //CLICK HOLD EVENTS

            $('div.arrowButton.next').mousedown(function () {
                timeoutId = setInterval(function () { menuInfo.MoveRight(20); }, 50);
            }).bind('mouseup mouseleave', function () {
                clearInterval(timeoutId);
            });

            $('div.arrowButton.back').mousedown(function () {
                timeoutId = setInterval(function () { menuInfo.MoveLeft(20); }, 50);
            }).bind('mouseup mouseleave', function () {
                clearInterval(timeoutId);
            });

            //TOUCH EVENTS

            this.targetList.bind('touchstart', function (e) {
                var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
                this.touchOffsetX = touch.pageX;

                document.bind("ontouchmove", lockHandler);

            });

            this.targetList.bind('touchend', function (e) {
                this.touchOffsetX = 0;

                document.unbind("ontouchmove", lockHandler);
            });

            this.targetList.bind('touchmove', function (e) {
                e.preventDefault();
                var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
                if ((this.touchOffsetX - touch.pageX) > 0) {
                    menuInfo.MoveRight(20)
                } else if ((this.touchOffsetX - touch.pageX) < 0) {
                    menuInfo.MoveLeft(20)
                }
            });

            $('div.arrowButton.next').bind('touchstart', function (e) {
                e.preventDefault();
                var frontInterval = setInterval(function () { menuInfo.MoveRight(15); }, 50);

                $('div.arrowButton.next').bind('touchend', function (e) {
                    e.preventDefault();
                    clearInterval(frontInterval);
                });
            });

            $('div.arrowButton.back').bind('touchstart', function (e) {
                e.preventDefault();
                var backInterval = setInterval(function () { menuInfo.MoveLeft(15); }, 50);

                $('div.arrowButton.back').bind('touchend', function (e) {
                    e.preventDefault();
                    clearInterval(backInterval);
                });
            });

        },

        unregisterEvents: function () {
            $("div.arrowButton.next").unbind("click");
            $("div.arrowButton.next").unbind("mousedown");
            $("div.arrowButton.next").unbind("mouseup");
            $("div.arrowButton.next").unbind("mouseleave");

            $("div.arrowButton.next").unbind("touchstart");
            $("div.arrowButton.next").unbind("touchend");

            $("div.arrowButton.back").unbind("click");
            $("div.arrowButton.back").unbind("mousedown");
            $("div.arrowButton.back").unbind("mouseup");
            $("div.arrowButton.back").unbind("mouseleave");

            $("div.arrowButton.back").unbind("touchstart");
            $("div.arrowButton.back").unbind("touchend");

            this.targetList.unbind("touchstart");
            this.targetList.unbind("ontouchmove");
            this.targetList.unbind("touchend");
        },

        onResize: function () {

            if ($("body").width() <= 800) {
                if (this.active == false) {
                    this.active = true;
                    this.initializeCarousel();
                }

                this.calculateWidth();

                if (this.containerWidth >= this.parentContainerWidth) {
                    //REGISTER EVENTS
                    if (!this.eventsOn) {
                        this.registerEvents();
                        this.eventsOn = true;
                        $(".content-block.shortcuts.carousel").addClass("active");
                    }

                    this.restorePositions();

                    this.maxNegMargin = (this.parentContainerWidth - this.containerWidth);

                } else {
                    if ($(".content-block.shortcuts.carousel").hasClass("active")) {
                        $(".content-block.shortcuts.carousel").removeClass("active");
                    }
                    if (this.eventsOn) {
                        this.unregisterEvents();
                        this.eventsOn = false;
                    }
                }
            } else {
                if (this.active == true) {
                    this.targetList.css("width", "auto");
                    this.active = false;
                }
            }

        },
        init: function () {

        }
    };
    return {
        Init: function () { _private.init(); },
        OnResize: function () { _private.onResize(); },
        MoveRight: function (speed) { _private.moveRight(speed); },
        MoveLeft: function (speed) { _private.moveLeft(speed); }
    };
})();
