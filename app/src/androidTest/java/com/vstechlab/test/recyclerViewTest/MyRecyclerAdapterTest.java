package com.vstechlab.test.recyclerViewTest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vstechlab.test.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class MyRecyclerAdapterTest {
    MyRecyclerAdapter mAdapter;
    Context mockContext;

    private static ArrayList<Contact> TEST_CONTACTS = new ArrayList<>();

    private static final String TEST_NAME1 = "Vijay";
    private static final String TEST_NAME2 = "Hardik";
    private static final String TEST_CONTACT1 = "98988898980";
    private static final String TEST_CONTACT2 = "98988898981";

    private static final Contact CONTACT1 = new Contact(TEST_NAME1, TEST_CONTACT1);
    private static final Contact CONTACT2 = new Contact(TEST_NAME2, TEST_CONTACT2);

    static {
        TEST_CONTACTS.add(CONTACT1);
        TEST_CONTACTS.add(CONTACT2);
    }

    @Before
    public void setUp() throws Exception {
        mockContext = InstrumentationRegistry.getTargetContext();
        mAdapter = new MyRecyclerAdapter(TEST_CONTACTS, mockContext);
    }

    @Test
    public void testGetItemCount() {
        assertEquals(TEST_CONTACTS.size(), mAdapter.getItemCount());
    }

    @Test
    public void testOnBindViewHolder_setContactDetailsAndClickEvent() {
        LayoutInflater inflater = (LayoutInflater)mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contactItem = inflater.inflate(R.layout.contact_item, null, false);
        MyRecyclerAdapter.MyViewHolder viewHolder = new MyRecyclerAdapter.MyViewHolder(contactItem);

        mAdapter.onBindViewHolder(viewHolder, 0);
        assertEquals(viewHolder.tvContact.getText().toString(), TEST_CONTACT1);
        assertEquals(viewHolder.tvName.getText().toString(), TEST_NAME1);
    }
}