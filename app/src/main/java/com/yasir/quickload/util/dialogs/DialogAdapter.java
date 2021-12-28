package com.yasir.quickload.util.dialogs;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.yasir.quickload.R;
import com.yasir.quickload.base.BaseAdapter;
import com.yasir.quickload.base.BaseViewHolder;
import com.yasir.quickload.databinding.ItemDialogListBinding;

public class DialogAdapter extends BaseAdapter<String> {
    @Override
    public boolean isEqual(String left, String right) {
        return false;
    }

    @Override
    public BaseViewHolder<String> newViewHolder(ViewGroup parent, int viewType) {
        return new DialogAdapterViewHolder(inflate(parent,R.layout.item_dialog_list));
    }
    private class DialogAdapterViewHolder extends BaseAdapterViewHolder<String>
    {
        ItemDialogListBinding mItemBinding;
        public DialogAdapterViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemDialogListBinding) viewDataBinding;
        }

        @Override
        public void bind(String item) {
            mItemBinding.textItem.setText(item);
        }
    }
}
