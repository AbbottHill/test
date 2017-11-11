
(function() {
    var graph = null;
    var paper = null;
    var rect = null;
    var rect2 = null;
    var link = null;
    var paperSmall = null;

    function init() {
        graph = new joint.dia.Graph;

        paper = new joint.dia.Paper({
            el: $('#myholder'),
            width: 1920,
            height: 1080,
            model: graph,
            gridSize: 1
        });

        rect = new joint.shapes.basic.Rect({
            position: { x: 260, y: 160 },
            size: { width: 100, height: 30 },
            attrs: { rect: { fill: 'blue' }, text: { text: 'my box', fill: 'white' } }
        });

        rect.attr({
            rect: { fill: '#2C3E50', rx: 5, ry: 5, 'stroke-width': 2, stroke: 'black' },
            text: {
                text: 'my label', fill: '#3498DB',
                'font-size': 18, 'font-weight': 'bold', 'font-variant': 'small-caps', 'text-transform': 'capitalize'
            }
        });

        rect2 = rect.clone();
        rect2.translate(300);

        link = new joint.dia.Link({
            source: { id: rect.id },
            target: { id: rect2.id }
        });

        //小窗口
        // paperSmall = new joint.dia.Paper({
        //     el: $('#myholder-small'),
        //     width: 600,
        //     height: 200,
        //     model: graph,
        //     gridSize: 1
        // });
        // paperSmall.scale(.3);
        // paperSmall.$el.css('pointer-events', 'none');

        // 画布主体overflow样式，添加滚动条
        var paperScroller = new joint.ui.PaperScroller({
            el: $('.paper-container'),
            paper: paper,
            autoResizePaper: false,
            padding:0
        });
        paper.on('blank:pointerdown', paperScroller.startPanning);
        // paperScroller.$el.css({ width:$(window).width()-300, height:$(window).height()-3}).appendTo('.paper-container');

        //添加缩略图导航
        var nav = new joint.ui.Navigator({
            paperScroller: paperScroller,
            width: 150,
            height: 150,
            padding: 10,
            currentViewControl:false,
            autoResizePaper:false,
            zoomOptions: { max: 2, min: 0.2 }
        });
        nav.$el.appendTo('.navigator-container');
        nav.render();

        // add cell
        graph.addCells([rect, rect2, link]);
    }
    
    function bindEvent() {
//event
        // graph.on('all', function(eventName, cell) {
        //     console.log(arguments);
        // });

        rect.on('change:position', function(element) {
            console.log(element.id, ':', element.get('position'));
        });
    }

    init();
    bindEvent();
})();

