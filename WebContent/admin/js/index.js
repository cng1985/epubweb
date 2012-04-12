<!--
$(function(){
    /* 初始化标签页 */
    initTopTab();
    /* 设置工作区 */
    setWorkspace();
    /* resize时重新设置工作区 */
    $(window).resize(setWorkspace);
});
function initTopTab(){
    $.each(menu, function(k, v){
        var item = $('<li><a class="link" href="javascript:;" id="tab_' + k + '">' + v.text + '</a></li>');
        item.children('a').click(function(){
			var tabName = this.id.substr(4);
			if(tabName == currTab){
			return;
			}
			switchTab(tabName);
			openItem();
		});
        $('#nav').append(item);
    });

    /* 切换到默认选项卡 */
    switchTab(currTab);
    openItem(firstOpen[1], firstOpen[0]);
    $('#iframe_refresh').click(function(){
        $('#workspace').get(0).contentWindow.location.reload();
    });
    $('#clear_cache').click(function(){
        var url = 'index.php?act=clear_cache';
        $.getJSON(url, {}, function(data){
            alert(data.msg);
        });
    });
}
function switchTab(tabName){
    currTab = tabName;
    pickTab();       //切换选项卡
    loadSubmenu();   //加载子菜单
}
function pickTab(){
    var id = '#tab_' + currTab;
    $('#nav').find('a').each(function(){
        $(this).removeClass('actived');
        $(this).addClass('link');
    });
    $(id).addClass('actived');
}
function loadSubmenu(){
    var m = menu[currTab];
    /* 子菜单标题 */
    $('#submenuTitle').text(m.subtext ? m.subtext : m.text);
    /* 删除所有现有子菜单 */
    $('#submenu').find('dd').remove();
    /* 将子菜单逐项添加到菜单中 */
    $.each(m.children, function(k, v){
        var p = v.parent ? v.parent : currTab;
        var item = $('<dd><a href="javascript:;" url="' + v.url + '" parent="' + p + '" id="item_' + k + '">' + v.text + '</a></dd>');
        item.children('a').click(function(){
            openItem(this.id.substr(5));
        });
        $('#submenu').append(item);
    });
}
function openItem(itemIndex, tab){
    if(typeof(itemIndex) == 'undefined')
    {
        var itemIndex = menu[currTab]['default'];
    }
    var id      = '#item_' + itemIndex;
    if(tab){
        var parent = tab;
    }else{
        var parent  = $(id).attr('parent');
    }
    /* 若不在当前选项卡内 */
    if(parent != currTab){
        /* 切换到指定选项卡 */
        switchTab(parent);
    }
    /* 高亮当前项 */
    $('#submenu').find('a').each(function(){
        $(this).removeClass('selected');
    });
    $(id).addClass('selected');

    /* 更新iframe的内容 */
    $('#workspace').show();
    $('#workspace').attr('src', $(id).attr('url'));
}
/* 设置工作区 */
function setWorkspace(){
    var wWidth = $(window).width();
    var wHeight = $(window).height();
    $('#workspace').width(wWidth - $('#left').width() - parseInt($('#left').css('margin-right')));
    $('#workspace').height(wHeight - $('#head').height());
}
//-->