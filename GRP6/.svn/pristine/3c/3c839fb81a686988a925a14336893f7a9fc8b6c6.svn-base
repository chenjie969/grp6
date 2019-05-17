/*
 * Bootstrap 3.3.6 IconPicker - jQuery plugin for Icon selection
 *
 * Copyright (c) 20013 A. K. M. Rezaul Karim<titosust@gmail.com>
 * Modifications (c) 20015 Paden Clayton<fasttracksites.com>
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Project home:
 *   https://github.com/titosust/Bootstrap-icon-picker
 *
 * Version:  1.0.1
 *
 */

(function($) {

    $.fn.iconPicker = function( options ) {
        
        var mouseOver=false;
        var $popup=null;
        var icons=new Array("icon-plus-sign","icon-remove-sign","icon-trash","icon-edit","icon-zoom-in","icon-glass","icon-music","icon-search","icon-envelope-alt","icon-heart","icon-star","icon-star-empty","icon-user","icon-film","icon-th-large","icon-th","icon-th-list","icon-ok","icon-remove",	"icon-zoom-out","icon-off","icon-signal","icon-cog","icon-home","icon-file-alt","icon-time","icon-road","icon-download-alt","icon-download","icon-upload","icon-inbox","icon-play-circle","icon-repeat","icon-refresh","icon-list-alt","icon-lock","icon-flag","icon-headphones","icon-volume-off","icon-volume-down","icon-volume-up","icon-qrcode","icon-barcode","icon-tag","icon-tags","icon-book","icon-bookmark","icon-print","icon-camera","icon-font","icon-bold","icon-italic","icon-text-height","icon-text-width","icon-align-left","icon-align-center","icon-align-right","icon-align-justify","icon-list","icon-indent-left","icon-indent-right","icon-facetime-video","icon-picture","icon-pencil","icon-map-marker","icon-adjust","icon-tint","icon-share","icon-check","icon-move","icon-step-backward","icon-fast-backward","icon-backward","icon-play","icon-pause","icon-stop","icon-forward","icon-fast-forward","icon-step-forward","icon-eject","icon-chevron-left","icon-chevron-right","icon-minus-sign","icon-ok-sign","icon-question-sign","icon-info-sign","icon-screenshot","icon-remove-circle","icon-ok-circle","icon-ban-circle","icon-arrow-left","icon-arrow-right","icon-arrow-up","icon-arrow-down","icon-share-alt","icon-resize-full","icon-resize-small","icon-plus","icon-minus","icon-asterisk","icon-exclamation-sign","icon-gift","icon-leaf","icon-fire","icon-eye-open","icon-eye-close","icon-warning-sign","icon-plane","icon-calendar","icon-random","icon-comment","icon-magnet","icon-chevron-up","icon-chevron-down","icon-retweet","icon-shopping-cart","icon-folder-close","icon-folder-open","icon-resize-vertical","icon-resize-horizontal","icon-bar-chart","icon-twitter-sign","icon-facebook-sign","icon-camera-retro","icon-key","icon-cogs","icon-comments","icon-thumbs-up-alt","icon-thumbs-down-alt","icon-star-half","icon-heart-empty","icon-signout","icon-linkedin-sign","icon-pushpin","icon-external-link","icon-signin","icon-trophy","icon-github-sign","icon-upload-alt","icon-lemon","icon-phone","icon-check-empty","icon-bookmark-empty","icon-phone-sign","icon-twitter","icon-facebook","icon-github","icon-unlock","icon-credit-card","icon-rss","icon-hdd","icon-bullhorn","icon-bell","icon-certificate","icon-hand-right","icon-hand-left","icon-hand-up","icon-hand-down","icon-circle-arrow-left","icon-circle-arrow-right","icon-circle-arrow-up","icon-circle-arrow-down","icon-globe","icon-wrench","icon-tasks","icon-filter","icon-briefcase","icon-fullscreen","icon-group","icon-link","icon-cloud","icon-beaker","icon-cut","icon-copy","icon-paper-clip","icon-save","icon-sign-blank","icon-reorder","icon-list-ul","icon-list-ol","icon-strikethrough","icon-underline","icon-table","icon-magic","icon-truck","icon-pinterest","icon-pinterest-sign","icon-google-plus-sign","icon-google-plus","icon-money","icon-caret-down","icon-caret-up","icon-caret-left","icon-caret-right","icon-columns","icon-sort","icon-sort-down","icon-sort-up","icon-envelope","icon-linkedin","icon-undo","icon-legal","icon-dashboard","icon-comment-alt","icon-comments-alt","icon-bolt","icon-sitemap","icon-umbrella","icon-paste","icon-lightbulb","icon-exchange","icon-cloud-download","icon-cloud-upload","icon-user-md","icon-stethoscope","icon-suitcase","icon-bell-alt","icon-coffee","icon-food","icon-file-text-alt","icon-building","icon-hospital","icon-ambulance","icon-medkit","icon-fighter-jet","icon-beer","icon-h-sign","icon-plus-sign-alt","icon-double-angle-left","icon-double-angle-right","icon-double-angle-up","icon-double-angle-down","icon-angle-left","icon-angle-right","icon-angle-up","icon-angle-down","icon-desktop","icon-laptop","icon-tablet","icon-mobile-phone","icon-circle-blank","icon-quote-left","icon-quote-right","icon-spinner","icon-circle","icon-reply","icon-github-alt","icon-folder-close-alt","icon-folder-open-alt","icon-expand-alt","icon-collapse-alt","icon-smile","icon-frown","icon-meh","icon-gamepad","icon-keyboard","icon-flag-alt","icon-flag-checkered","icon-terminal","icon-code","icon-reply-all","icon-mail-reply-all","icon-star-half-empty","icon-location-arrow","icon-crop","icon-code-fork","icon-unlink","icon-question","icon-info","icon-exclamation","icon-superscript","icon-subscript","icon-eraser","icon-puzzle-piece","icon-microphone","icon-microphone-off","icon-shield","icon-calendar-empty","icon-fire-extinguisher","icon-rocket","icon-maxcdn","icon-chevron-sign-left","icon-chevron-sign-right","icon-chevron-sign-up","icon-chevron-sign-down","icon-html5","icon-css3","icon-anchor","icon-unlock-alt","icon-bullseye","icon-ellipsis-horizontal","icon-ellipsis-vertical","icon-rss-sign","icon-play-sign","icon-ticket","icon-minus-sign-alt","icon-check-minus","icon-level-up","icon-level-down","icon-check-sign","icon-edit-sign","icon-external-link-sign","icon-share-sign","icon-compass","icon-collapse","icon-collapse-top","icon-expand","icon-eur","icon-gbp","icon-usd","icon-inr","icon-jpy","icon-cny","icon-krw","icon-btc","icon-file","icon-file-text","icon-sort-by-alphabet","icon-sort-by-alphabet-alt","icon-sort-by-attributes","icon-sort-by-attributes-alt","icon-sort-by-order","icon-sort-by-order-alt","icon-thumbs-up","icon-thumbs-down","icon-youtube-sign","icon-youtube","icon-xing","icon-xing-sign","icon-youtube-play","icon-dropbox","icon-stackexchange","icon-instagram","icon-flickr","icon-adn","icon-bitbucket","icon-bitbucket-sign","icon-tumblr","icon-tumblr-sign","icon-long-arrow-down","icon-long-arrow-up","icon-long-arrow-left","icon-long-arrow-right","icon-apple","icon-windows","icon-android","icon-linux","icon-dribbble","icon-skype","icon-foursquare","icon-trello","icon-female","icon-male","icon-gittip","icon-sun","icon-moon","icon-archive","icon-bug","icon-vk","icon-weibo","icon-renren");
        var settings = $.extend({
        	
        }, options);
        return this.each( function() {
        	element=this;
        	
            if(!settings.buttonOnly && $(this).data("iconPicker")==undefined ){
            	$this=$(this).addClass("form-control");
            	$wraper=$("<div/>",{class:"input-group bootstrap-timepicker"});
            	$this.wrap($wraper);

            	$button=$("<span class=\"input-group-addon\"><i class=\"icon-picture bigger-110\"></i></span>");
            	$this.after($button);
            	(function(ele){
	            	$button.click(function(){
			       		createUI(ele);
			       		showList(ele,icons);
	            	});
	            })($this);

            	$(this).data("iconPicker",{attached:true});
            }
        
	        function createUI($element){
	        	$popup=$('<div/>',{
	        		css: {
		        		'top':$element.offset().top+$element.outerHeight()+6,
		        		'left':$element.offset().left
		        	},
		        	class:'icon-popup'
	        	})

	        	$popup.html('<div class="ip-control"> \
						          <ul> \
						            <li><a href="javascript:;" class="btn" data-dir="-1" style="border:0;"><span class=\"glyphicon  icon-fast-backward bigger-110\"></span></a></li> \
						            <li><a href="javascript:;" class="btn" data-dir="1" style="border:0;"><span class=\"glyphicon icon-fast-forward bigger-110 \"></span></a></li> \
						          </ul> \
						      </div> \
						     <div class="icons-list"> </div> \
					         ').appendTo("body");
	        	
	        	
	        	$popup.addClass('dropdown-menu').show();
				$popup.mouseenter(function() {  mouseOver=true;  }).mouseleave(function() { mouseOver=false;  });

	        	var lastVal="", start_index=0,per_page=30,end_index=start_index+per_page;
	        	$(".ip-control .btn",$popup).click(function(e){
	                e.stopPropagation();
	                var dir=$(this).attr("data-dir");
	                start_index=start_index+per_page*dir;
	                start_index=start_index<0?0:start_index;
	                if(start_index+per_page<=210){
	                  $.each($(".icons-list>ul li"),function(i){
	                      if(i>=start_index && i<start_index+per_page){
	                         $(this).show();
	                      }else{
	                        $(this).hide();
	                      }
	                  });
	                }else{
	                  start_index=180;
	                }
	            });
	        	
	        	$('.ip-control .ip-search',$popup).on("keyup",function(e){
	                if(lastVal!=$(this).val()){
	                    lastVal=$(this).val();
	                    if(lastVal==""){
	                    	showList(icons);
	                    }else{
	                    	showList($element, $(icons)
							        .map(function(i,v){ 
								            if(v.toLowerCase().indexOf(lastVal.toLowerCase())!=-1){return v} 
								        }).get());
						}
	                    
	                }
	            });  
	        	$(document).mouseup(function (e){
				    if (!$popup.is(e.target) && $popup.has(e.target).length === 0) {
				        removeInstance();
				    }
				});

	        }
	        function removeInstance(){
	        	$(".icon-popup").remove();
	        }
	        function showList($element,arrLis){
	        	$ul=$("<ul>");
	        	
	        	for (var i in arrLis) {
	        		$ul.append("<li><a href=\"#\" title="+arrLis[i]+"><span class=\""+arrLis[i]+"\"></span></a></li>");
	        	};

	        	$(".icons-list",$popup).html($ul);
	        	$(".icons-list li a",$popup).click(function(e){
	        		e.preventDefault();
	        		var title=$(this).attr("title");
	        		$element.val(""+title);
	        		removeInstance();
	        	});
	        }

        });
    }

}(jQuery));
