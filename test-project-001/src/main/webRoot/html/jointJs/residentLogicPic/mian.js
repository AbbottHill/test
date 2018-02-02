var graph = null;
var paper = null;
var rect = null;
var rect2 = null;
var link = null;
var paperSmall = null;
var background = null;
var paperScroller = null;


joint.shapes.basic.myRect = joint.shapes.basic.Generic.extend({
    markup: '<g class="rotatable"><g class="scalable"><rect/></g><text/></g>',
    defaults: joint.util.deepSupplement({
        type: 'basic.myRect',
        attrs: {
            'rect': {fill: 'white', stroke: 'black', 'follow-scale': true, width: 80, height: 40},
            'text': {
                'font-size': 14,
                'ref-x': .5,
                'ref-y': .5,
                ref: 'rect',
                'y-alignment': 'middle',
                'x-alignment': 'middle'
            }
        }
    }, joint.shapes.basic.Generic.prototype.defaults)
});

joint.shapes.basic.myBigRect = joint.shapes.basic.Generic.extend({
    markup: '<g class="rotatable"><g class="scalable"><rect/></g><text/></g>',
    defaults: joint.util.deepSupplement({
        type: 'basic.myBigRect',
        attrs: {
            'rect': {
                fill: 'white', stroke: 'black',
                'follow-scale': true, width: 80, height: 340,
                border: 'dashed'
            },
            'text': {
                'font-size': 14,
                'ref-x': .5,
                'ref-y': .5,
                ref: 'rect',
                'y-alignment': 'middle',
                'x-alignment': 'middle'
            }
        }
    }, joint.shapes.basic.Generic.prototype.defaults)
});


$(window).resize(function () {
    $(".joint-paper-scroller").height($(window).height() - 165);//智能分析去除滚动条  原来高度为 $(window).height()-65
    $(".joint-paper-scroller").width($(window).width() - 225);//智能分析去除滚动条  原来高度为 $(window).height()-65
});


function init() {
    $("#zoomIn").unbind().bind('click', function () {
        paperScroller.zoom(0.05, {max: 2});
    });
    $("#zoomOut").unbind().bind('click', function () {
        paperScroller.zoom(-0.05, {min: 0.4});
    });
    $("#scaleIn").unbind().bind('click', function () {
        paper.scale(paper.scale().sx + 0.05);
    });
    $("#scaleOut").unbind().bind('click', function () {
        paper.scale(paper.scale().sx - 0.05);
    });
    $("#scaleNone").unbind().bind('click', function () {
        paper.scale(1);
    });

    $("#fitContent").unbind().bind('click', function () {
        paperScroller.addPadding(0, 0, 0, 0);
        paper.fitToContent();
        paper.scale(1, 1);
    });


    graph = new joint.dia.Graph;

    paper = new joint.dia.Paper({
        el: $('#myholder'),
        width: 1920,
        height: 1080,
        model: graph,
        gridSize: 1
    });

    //background
    // background = V('<image/>');
    // // background = V('<image width="1920px" height="1080px"/>');
    // background.attr({
    //     // 'xlink:href': 'https://file.isolarcloud.com/stpic/100004/file18220171110191652063.jpg', height: 780, width:1000
    //     'xlink:href': '/resources/images/lianhua.png'
    //     // 'xlink:href': '/resources/images/933.png'
    // });
    // V(paper.viewport).prepend(background);

    // 画布主体overflow样式，添加滚动条
    paperScroller = new joint.ui.PaperScroller({
        el: $('.paper-container'),
        paper: paper,
        autoResizePaper: false,
        padding: 0,
        cursor: 'grab'
    });

    paper.on('blank:pointerdown', paperScroller.startPanning);

    $(window).resize();
}

function showNavigate() {
    //添加缩略图导航
    var nav = new joint.ui.Navigator({
        paperScroller: paperScroller,
        width: 150,
        height: 150,
        padding: 10,
        currentViewControl: false,
        autoResizePaper: false,
        zoomOptions: {max: 2, min: 0.2}
    });
    nav.$el.appendTo('.navigator-container');
    nav.render();
}

/**
 * 画矩阵
 */
function drawMatrix() {
    //间隔
    var intervalX = 100, intervalY = 160;
    //高宽
    var itemWidth = 60, itemHeight= 50;
    var items = [], links = [];
    //列数，行数，x坐标，y坐标
    var countX = 10, countY = 4, initPositionX = 100, initPositionY = 100, positionX = 100, positionY = 100;
    for (var i = 0, lens = countY; i < lens; i++) {
        for (var j = 0, length = countX; j < length; j++) {
            positionX += intervalX;
            var item = new joint.shapes.basic.Rect({
                position: {x: positionX, y: positionY},
                size: {width: itemWidth, height: itemHeight},
                attrs: {rect: {fill: 'green'}, text: {text: j + '-' + i, fill: 'white'}}
            });
            items.push(item);
        }
        positionX = 100;
        positionY += intervalY;
    }

    //行内连线
    for (var i = 1, lens = items.length; i < lens; i++) {
        if (i % countX == 0) {
            continue;
        }
        var link = createLinkByItems(items[i - 1], items[i]);
        links.push(link);
    }

    //行间连线
    var link = createLinkByItems(items[0], items[countX]);
    links.push(link);
    var link = createLinkByItems(items[2 * countX], items[3 * countX]);
    links.push(link);

    graph.addCells(items);
    graph.addCells(links);


    var bigRctPositionX = positionX + intervalX * countX + 200;
    var bigRctPositionY = initPositionY;
    var bigRctHeight = intervalY * countY;
    var bigRectangle = new joint.shapes.basic.myBigRect({
        position: {x: bigRctPositionX, y: bigRctPositionY},
        size: {width: 90, height: bigRctHeight},
        attrs: {rect: {fill: 'white'}, text: {text: j + '-' + i, fill: 'black'}}
    });

    graph.addCell(bigRectangle);

    connectBigRectangle(items[2 * countX - 1], bigRectangle, countX, itemHeight, itemWidth);
    connectBigRectangle(items[3 * countX - 1], bigRectangle, countX, itemHeight, itemWidth);

}

/**
 * 根据元素连线
 */
function createLinkByItems(item1, item2) {
    if (canDoUtils.isUndefinedOrNull(item1) || canDoUtils.isUndefinedOrNull(item2)) {
        return;
    }
    var link = new joint.dia.Link({
        source: {id: item1.id},
        target: {id: item2.id}
    });
    return link;
}

/**
 * 根据起止坐标连线
 */
function createLinkByPositions(sourceX, sourceY, targetX, targetY) {
    if (!$.isNumeric(sourceX) || !$.isNumeric(sourceY) || !$.isNumeric(targetX) || !$.isNumeric(targetY)) {
        return;
    }
    var link = new joint.dia.Link({
        source: {x: sourceX, y: sourceY},
        target: {x: targetX, y: targetY}
        // vertices: [{x: 400, y: 60}, {x: 550, y: 60}, {x: 550, y: 20}]
    });
    return link;
}

/**
 * 小连大
 */
function connectBigRectangle(smallRectangle, BigRectangleObj, countX, itemHeight, itemWidth) {
    //链接纵坐标
    var connectY = smallRectangle.attributes.position.y + itemHeight/2;
    link = createLinkByPositions(smallRectangle.attributes.position.x + itemWidth, connectY, BigRectangleObj.attributes.position.x, connectY);
    graph.addCell(link);
}

function bindEvent() {

//event
    // graph.on('all', function(eventName, cell) {
    //     console.log(arguments);
    // });
    rect.on('change:position', function (element) {
        console.log(element.id, ':', element.get('position'));
    });
}

init();
drawMatrix();
// drawElements();
showNavigate();
// bindEvent();

