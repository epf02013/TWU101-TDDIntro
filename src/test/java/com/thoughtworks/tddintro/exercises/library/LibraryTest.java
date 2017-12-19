package com.thoughtworks.tddintro.exercises.library;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);

        library.listBooks();

        verify(printStream).println(title+="\n");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String title1 = "Book One";
        String title2 = "Book Two";
        books.add(title1);
        books.add(title2);

        library.listBooks();

        verify(printStream).println(title1+"\n"+title2+"\n");
    }

    @Test
    public void shouldAddBookToCollectionWhenEnteredByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Hobbit");
        library.enterBook();
        assertThat(books, hasItems("The Hobbit"));
    }

    @Test
    public void shouldDeleteBookFromCollectionWhenRemovedByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Two Towers");

        books.add("The Two Towers");
        library.removeBook();

        assertThat(books, not(hasItems("The Two Towers")));
    }
}
