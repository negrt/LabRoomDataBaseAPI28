package com.example.labroomdatabaseapi28;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolderClass> {

    private List<Person> personList;

    // Constructor
    public PersonAdapter(List<Person> personList)
    {
        this.personList = personList;
    }

    // Create view holder
    @NonNull
    @Override
    public PersonViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_recyclerview, viewGroup, false);

        return new PersonViewHolderClass(itemView);
    }

    // Bind data
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolderClass personViewHolderClass,
                                 int i)
    {
        Person person = personList.get(i);

        personViewHolderClass.textViewId.setText(Integer.toString(person.getId()));
        personViewHolderClass.textViewName.setText(person.getFirstName());
        personViewHolderClass.textViewAddress.setText(person.getAddress());

    }

    // Get the size of the list
    @Override
    public int getItemCount() {
        return personList.size();
    }


    // Class to help bind data
    public class PersonViewHolderClass extends RecyclerView.ViewHolder
    {
        public TextView textViewId;
        public TextView textViewName;
        public TextView textViewAddress;

        public PersonViewHolderClass(View view)
        {
            super(view);
            // Initialize these textviews
            textViewId = view.findViewById(R.id.textViewId);
            textViewAddress = view.findViewById(R.id.textViewAddress);
            textViewName = view.findViewById(R.id.textViewName);
        }
    }
}
