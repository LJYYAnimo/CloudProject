<!doctype html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Video.js 7.0</title>
	<link href="/js/VideoJs/css/video-js.min.css" rel="stylesheet">
	<style>
body {
	background-color: #191919
}
.m {
	width: 960px;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
}
.video-js .vjs-big-play-button{
    top: 50%;
    left: 45%;
}
</style>
	</head>

	<body>
    <div class="m">
      <#--<video id="my-video" class="video-js" controls preload="auto" width="960" height="400"-->
		  <#--poster="" data-setup="{}">-->
        <#--<source id="videos" src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">-->
        <#--<p class="vjs-no-js"> 请使用最新的浏览器来观看视频 <a href="http://videojs.com/html5-video-support/" target="_blank"></a> </p>-->
      <#--</video>-->
      <script src="/js/VideoJs/js/video.min.js"></script>
      <script src="/js/VideoJs/js/zh-CN.js"></script>
	  <script src="/js/jquery.min.js"></script>
      <script type="text/javascript">
          var value;

          function child(d) {
              value = null;
              if (d != null) {
                  value = d;
              }
          }
          setTimeout(function() {
              if(value!=undefined&&value!=null&&value.videoPath!=''){
                  var vido = value.videoPath.split('/');
                  var exts = vido[vido.length-1].split('.')
                  var type = exts[exts.length-1];
//                  $('#videos').attr("type","video/"+type);
//                  $('#videos').attr("src",value.videoPath);
//                  $('#my-video').attr("poster",value.imgPath);
                  $(".m").append(' <video id="my-video" class="video-js" controls preload="auto" width="960" height="540"' +
                          '  poster="'+value.imgPath+'" data-setup="{}">' +
                          '        <source id="videos" src="'+value.videoPath+'" type="video/'+type+'">' +
                          '        <p class="vjs-no-js"> 请使用最新的浏览器来观看视频 <a href="http://videojs.com/html5-video-support/" target="_blank"></a> </p>' +
                          '      </video>');
                  var myPlayer = videojs('my-video');
                  videojs("my-video").ready(function(){
//                      var myPlayer = this;
//                      myPlayer.play();
                  });
              }

          },300);

			  
		</script> 
    </div>
</body>
</html>
