package firstweek.zhoukao.czj.zhoukaoyi.application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;


public class ImageLoaderOptionsUtils {
    public static DisplayImageOptions getOptions(int imageId) {
        DisplayImageOptions options =
                new DisplayImageOptions.Builder().
                        displayer(new RoundedBitmapDisplayer(0)).
                        showImageOnLoading(imageId).showImageForEmptyUri(imageId)
                        .cacheInMemory()
                        .cacheOnDisk(true)
                        .build();
        return options;
    }

}