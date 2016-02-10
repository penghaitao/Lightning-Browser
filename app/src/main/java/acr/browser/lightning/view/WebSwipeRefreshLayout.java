package acr.browser.lightning.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by penghaitao on 2016/2/9.
 */
public class WebSwipeRefreshLayout extends SwipeRefreshLayout {

    public WebSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public WebSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private CanChildScrollUpCallback mCanChildScrollUpCallback;

    public interface CanChildScrollUpCallback {
        boolean canSwipeRefreshChildScrollUp();
    }

    public void setCanChildScrollUpCallback(CanChildScrollUpCallback canChildScrollUpCallback) {
        mCanChildScrollUpCallback = canChildScrollUpCallback;
    }

    @Override
    public boolean canChildScrollUp() {
        if (mCanChildScrollUpCallback != null) {
            return mCanChildScrollUpCallback.canSwipeRefreshChildScrollUp();
        }
        return super.canChildScrollUp();
    }
}