 $(document).ready(function () {
    var video1 = document.getElementById('video1');
    var video1Playing = false;

    $('#fullpage').fullpage({
      // FullPage.js settings

      afterLoad: function (anchorLink, index) {
        if (index === 1) {
          if (!video1Playing) {
            playVideo('video1'); // Play the video only if it's not already playing
            video1Playing = true;
          }
        } else {
          if (video1Playing) {
            pauseVideo('video1'); // Pause the video when leaving Section 1
            video1Playing = false;
          }
        }
      },
    });

    function playVideo(videoId) {
      var video = document.getElementById(videoId);
      if (video) {
        video.play();
      }
    }

    function pauseVideo(videoId) {
      var video = document.getElementById(videoId);
      if (video) {
        video.pause();
      }
    }
  });