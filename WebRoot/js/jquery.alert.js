(function ($) {
    $.extend({
        _isalert:0,
        alert:function(){
            if(arguments.length){
                $._isalert=1;
                $.confirm.apply($,arguments);
            }
        },
        confirm:function(){
            var args=arguments;
            if(args.length&&(typeof args[0] == 'string')&&!$('#alert_overlay').length){
                if(!$('#alert_style').length) $('body').append('<style id="alert_style" type="text/css">#alert_overlay{position:fixed;width:100%;height:100%;top:0;left:0;z-index:999;background:#ccc;filter:alpha(opacity=30);opacity:.3}#alert_msg{position:fixed;width:400px;margin-left:-201px;left:50%;top:20%;z-index:1000;border:1px solid #aaa;box-shadow:0 2px 15px rgba(0,0,0,.3);background:#d58512}#alert_content{padding:20px;font-size:14px;text-align:left}#alert_buttons{padding:10px;border-top:1px solid #aaa;text-align:right;box-shadow:0 1px 0 #fff inset;background:#eee;-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none}#alert_buttons .alert_btn{padding:5px 12px;margin:0 2px;border:1px solid #aaa;background:#eee;cursor:pointer;border-radius:2px;font-size:14px;outline:0;-webkit-appearance:none}#alert_buttons .alert_btn:hover{border-color:#bbb;box-shadow:0 1px 2px #aaa;background:#eaeaea}#alert_buttons .alert_btn:active{box-shadow:0 1px 2px #aaa inset;background:#e6e6e6}</style>');
                var dialog=$('<div id="alert_overlay"></div><div id="alert_msg"><div id="alert_content">'+args[0]+'</div><div id="alert_buttons"><button class="alert_btn alert_btn_ok">确定</button><button class="alert_btn alert_btn_cancel">取消</button></div></div>');
                if($._isalert) dialog.find('.alert_btn_cancel').hide();
                dialog.on('contextmenu',function(){
                    return !1;
                }).on('click','.alert_btn_ok',function(){
                    dialog.remove();
                    if(typeof args[1]=='function') args[1].call($,!0);
                }).on('click','.alert_btn_cancel',function(){
                    dialog.remove();
                    if(typeof args[1]=='function') args[1].call($,!1);
                }).appendTo('body');
            }
            $._isalert=0;
        }
    });
})($);