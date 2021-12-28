package com.yasir.quickload.util.dialogs;

import android.bluetooth.BluetoothDevice;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.yasir.quickload.R;
import com.yasir.quickload.base.BaseAdapter;
import com.yasir.quickload.base.BaseViewHolder;
import com.yasir.quickload.databinding.ItemDialogListBinding;

public class DialogAdapter extends BaseAdapter<BluetoothDevice> {
    @Override
    public boolean isEqual(BluetoothDevice left, BluetoothDevice right) {
        return false;
    }

    @Override
    public BaseViewHolder<BluetoothDevice> newViewHolder(ViewGroup parent, int viewType) {
        return new DialogAdapterViewHolder(inflate(parent,R.layout.item_dialog_list));
    }
    private class DialogAdapterViewHolder extends BaseAdapterViewHolder<BluetoothDevice>
    {
        ItemDialogListBinding mItemBinding;
        public DialogAdapterViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding);
            mItemBinding = (ItemDialogListBinding) viewDataBinding;
        }

        @Override
        public void bind(BluetoothDevice item) {
            mItemBinding.textItem.setText(""+item.getAddress());
        }
    }
}
