package com.althink.android.ossw.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.althink.android.ossw.MainActivity;
import com.althink.android.ossw.R;
import com.althink.android.ossw.db.OsswDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Vasilyev on 07/04/16.
 */
public class PredefinedMessagesFragment extends ListFragment {

    private final static String TAG = PredefinedMessagesFragment.class.getSimpleName();
    private LayoutInflater mInflater;

    private MessageListAdapter listAdapter;

    public PredefinedMessagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called");
        mInflater = inflater;
        View v = inflater.inflate(R.layout.fragment_predefined_messages, container, false);
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate called");
        listAdapter = new MessageListAdapter();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated called");
        setTitle("Predefined messages");
        setListAdapter(listAdapter);
        refreshPredefinedMessageList();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.i(TAG, "onCreateOptionsMenu called");
        inflater.inflate(R.menu.predefined_messages, menu);
        updateMenuOptions();
    }

    private void refreshPredefinedMessageList() {
        listAdapter.clear();
        if (isAdded())
            listAdapter.addMessageIds(OsswDatabaseHelper.getInstance(getContext()).getPredefinedMessageIds());
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        updateMenuOptions();
    }

    private void updateMenuOptions() {
        if (getView() != null) {
            int checkedCount = getListView().getCheckedItemCount();
            setMenuOptions(checkedCount > 0 ? (checkedCount > 1 ? Mode.MULTI : Mode.SINGLE) : Mode.NONE);
        }
    }

    private void setMenuOptions(Mode mode) {
        if (!isAdded())
            return;
        Toolbar mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_actionbar);
        Menu menu = mToolbar.getMenu();
//        MenuItem addAction = menu.findItem(R.id.menu_add);
        MenuItem removeAction = menu.findItem(R.id.menu_remove);
        MenuItem editAction = menu.findItem(R.id.menu_edit);
        switch (mode) {
            case MULTI:
                editAction.setVisible(false);
                removeAction.setVisible(true);
                break;
            case SINGLE:
                editAction.setVisible(true);
                removeAction.setVisible(true);
                break;
            case NONE:
                editAction.setVisible(false);
                removeAction.setVisible(false);
                break;
        }
    }

    private void resetSelection() {
        ListView listView = getListView();
        listView.clearChoices();
        listView.requestLayout();
        setMenuOptions(Mode.NONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume called");
    }

    public void openMessageEditDialog(final boolean newMsg, final int msgId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        // I'm using fragment here so I'm using getView() to provide ViewGroup
        // but you can provide here any other instance of ViewGroup from your Fragment / Activity
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.text_edit_dialog, (ViewGroup) getView(), false);
        // Set up the input
        final EditText input = (EditText) viewInflated.findViewById(R.id.message_text);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        builder.setView(viewInflated);
        final OsswDatabaseHelper db = OsswDatabaseHelper.getInstance(getContext());
        if (newMsg)
            builder.setTitle("New message");
        else {
            builder.setTitle("Edit message");
            input.setText(db.getPredefinedMessageText(msgId));
        }

        // Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String mText = input.getText().toString();
                if (newMsg)
                    db.insertPredefinedMessage(mText);
                else
                    db.updatePredefinedMessage(msgId, mText);
                refreshPredefinedMessageList();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        OsswDatabaseHelper db = OsswDatabaseHelper.getInstance(getContext());
        if (id == R.id.menu_add) {
            openMessageEditDialog(true, 0);
            resetSelection();
            return true;
        } else if (id == R.id.menu_remove) {
            SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
            int count = getListView().getCount();
            for (int i = 0; i < count; i++) {
                if (sparseBooleanArray.get(i)) {
                    db.deletePredefinedMessage((Integer) getListAdapter().getItem(i));
                }
            }
            refreshPredefinedMessageList();
            resetSelection();
            return true;
        } else if (id == R.id.menu_edit) {
            SparseBooleanArray sparseBooleanArray = getListView().getCheckedItemPositions();
            int count = getListView().getCount();
            for (int i = 0; i < count; i++) {
                if (sparseBooleanArray.get(i) && isAdded()) {
                    openMessageEditDialog(false, (Integer) getListAdapter().getItem(i));
                }
            }
            resetSelection();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Log.i(TAG, "On destroy");
    }

    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    private class MessageListAdapter extends BaseAdapter {
        private ArrayList<Integer> messageIds;

        public MessageListAdapter() {
            super();
            messageIds = new ArrayList<>();
        }

        public void addMessageId(int msg) {
            messageIds.add(msg);
        }

        public void addMessageIds(List<Integer> msgIds) {
            messageIds.addAll(msgIds);
        }

        public Integer getMessageId(int position) {
            return messageIds.get(position);
        }

        public void clear() {
            messageIds.clear();
        }

        @Override
        public int getCount() {
            return messageIds.size();
        }

        @Override
        public Object getItem(int i) {
            return messageIds.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            // General ListView optimization code.
            if (view == null) {
                view = mInflater.inflate(R.layout.listitem_predefined_message, null);
                viewHolder = new ViewHolder();
                viewHolder.messageText = (TextView) view.findViewById(R.id.message_text);
                viewHolder.messageCount = (TextView) view.findViewById(R.id.message_count);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            OsswDatabaseHelper dbHelper = OsswDatabaseHelper.getInstance(getContext());
            int msgId = messageIds.get(i);
            viewHolder.messageText.setText(dbHelper.getPredefinedMessageText(msgId));
            viewHolder.messageCount.setText(dbHelper.getPredefinedMessageCount(msgId).toString());
            return view;
        }
    }

    static class ViewHolder {
        TextView messageText;
        TextView messageCount;
    }

    private enum Mode {
        NONE, SINGLE, MULTI
    }
}
