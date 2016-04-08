package com.app.bookmybarber.interfaces;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Used for listening to RecyclerView item clicks. You can either implement an OnItemLongClickListener
 * or extend SimpleOnItemClickListener and override its methods.
 *
 * Licence: MIT
 *
 */
public class RecyclerItemLongClickListener implements RecyclerView.OnItemTouchListener {

    protected OnItemLongClickListener listener;

    private GestureDetector gestureDetector;

    @Nullable
    private View childView;

    private int childViewPosition;

    public RecyclerItemLongClickListener(Context context, OnItemLongClickListener listener) {
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        this.listener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent event) {
        childView = view.findChildViewUnder(event.getX(), event.getY());
        childViewPosition = view.getChildPosition(childView);

        return childView != null && gestureDetector.onTouchEvent(event);
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent event) {
        // Not needed.
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)
    {

    }

    /**
     * A click listener for items.
     */
    public interface OnItemLongClickListener {

        /**
         * Called when an item is long pressed.
         *
         * @param childView View of the item that was long pressed.
         * @param position  Position of the item that was long pressed.
         */
        public void onItemLongPress(View childView, int position);

    }

    protected class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            if (childView != null) {
                listener.onItemLongPress(childView, childViewPosition);
            }
        }

        @Override
        public boolean onDown(MotionEvent event) {
            return false;
        }

    }

}