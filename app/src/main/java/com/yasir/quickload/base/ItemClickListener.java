/*
 * Project Name   : NybSys_PTT
 * Created By  	  : skfaisal
 * Created Date	  : 12/27/20 11:00 AM
 * Last edited by :  skfaisal
 * Edited time    : 10/13/20 11:21 AM
 * Purpose        :
 * (c) NybSys Ltd.
 *  ======================
 *
 */

package com.yasir.quickload.base;

import android.view.View;


/**
 * We have added one default interface method because developers often need the index of item along
 * with with item. Normally index leess interface is preferable to use.
 * Works with {@link BaseAdapter} normally
 */
public interface ItemClickListener<T> {
    /**
     * Called when a item has been clicked.
     *
     * @param view The view that was clicked.
     * @param item The T type object that was clicked.
     */
    void onItemClick(View view, T item);


    /**
     * Developers might often need the index of item.
     * @param view
     * @param item
     * @param index
     */
    default void onItemClick(View view, T item, int index) { }
}
