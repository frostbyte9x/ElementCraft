package com.appx.elementcraft;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appx.elementcraft.databinding.DropDownListItemBinding;
import com.appx.elementcraft.databinding.SearchableTextInputBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SearchableTextInput extends LinearLayout {
    private AutoCompleteTextView textInput;
    private TextView heading;
    private OnItemClickListener listener;

    public SearchableTextInput(@NonNull Context context) {
        super(context);
        init(context);
    }

    public SearchableTextInput(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TextInput);
        String text = array.getString(R.styleable.TextInput_text);
        String hintText = array.getString(R.styleable.TextInput_hint);
        String headingText = array.getString(R.styleable.TextInput_heading_text);
        configure(headingText, text, hintText);
        array.recycle();
    }

    private void init(Context context) {
        SearchableTextInputBinding binding = SearchableTextInputBinding.inflate(LayoutInflater.from(context), this, true);
        textInput = binding.searchableInput;
        heading = binding.heading;
        textInput.setDropDownBackgroundResource(R.drawable.popup_bg);

        textInput.setOnItemClickListener((parent, view, position, id) -> {
            SearchableList selectedItem = (SearchableList) parent.getItemAtPosition(position);
            listener.onItemSelected(position, selectedItem);
            textInput.setText(null);
        });
    }

    public void specifySuggestions(Context context, List<SearchableList> dataList) {
        SearchableTextAdapter adapter = new SearchableTextAdapter(context, dataList);
        textInput.setAdapter(adapter);
    }

    public void setHeading(String text) {
        heading.setText(text);
    }

    public void setText(CharSequence text) {
        textInput.setText(text);
    }

    public void setHint(CharSequence text) {
        textInput.setHint(text);
    }

    public String getText() {
        return textInput.getText().toString().trim();
    }

    public void configure(String heading, String text, String hint) {
        if (text != null)
            setText(text);
        if (hint != null)
            setHint(hint);
        if (heading != null)
            setHeading(heading);
    }

    public void setMaxTextLimit(int textLimit) {
        textInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(textLimit)});
    }

    public static class SearchableList {
        private String itemName;
        private int iconId;
        private String theme;

        public SearchableList(String itemName, int iconId, String theme) {
            this.itemName = itemName;
            this.iconId = iconId;
            this.theme = theme;
        }

        public String getItemName() {
            return itemName;
        }

        public int getIconId() {
            return iconId;
        }

        public String getTheme() {
            return theme;
        }
    }

    private static class SearchableTextAdapter extends ArrayAdapter<SearchableList> {
        private List<SearchableList> searchableListAll;

        public SearchableTextAdapter(Context context, List<SearchableList> data) {
            super(context, 0, data);
            searchableListAll = new ArrayList<>(data);
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return searchFilter;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                DropDownListItemBinding binding = DropDownListItemBinding.inflate(LayoutInflater.from(getContext()), parent, false);
                convertView = binding.getRoot();
                holder = new ViewHolder(binding);
                convertView.setTag(holder);
            } else
                holder = (ViewHolder) convertView.getTag();

            SearchableList item = getItem(position);
            if (item != null)
                holder.bind(item);

            return convertView;
        }

        private Filter searchFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<SearchableList> suggestions = new ArrayList<>();

                if (constraint == null || constraint.length() == 0)
                    suggestions.addAll(searchableListAll);
                else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (SearchableList item : searchableListAll)
                        if (item.getItemName().toLowerCase().startsWith(filterPattern))
                            suggestions.add(item);
                }
                results.values = suggestions;
                results.count = suggestions.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                if(results.values instanceof List<?>)
                {
                    addAll((List<SearchableList>) results.values);
                    notifyDataSetChanged();
                }
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((SearchableList) resultValue).getItemName();
            }
        };

        public static class ViewHolder {
            private final ImageView imageView;
            private final TextView title;

            ViewHolder(DropDownListItemBinding binding) {
                imageView = binding.imageView;
                title = binding.textView;
            }

            void bind(SearchableList item) {
                imageView.setImageResource(item.getIconId());
                title.setText(item.getItemName());
            }
        }
    }

    public interface OnItemClickListener
    {
        void onItemSelected(int position, SearchableList selectedItem);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
    }
}

