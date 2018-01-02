package hu.abb.controller;

import hu.abb.entity.Item;
import hu.abb.service.ItemService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author: Balogh Ádám Bence
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
    private static final long ITEM_ID_2 = 2L;
    @InjectMocks
    private ItemController itemController;
    @Mock
    private ItemService mockItemService;

    @Test
    public void shouldReturn404WhenItemCouldNotBeFoundById(){
        //given
        when(mockItemService.findById(ITEM_ID_2)).thenReturn(Optional.empty());
        //when
        ResponseEntity<Item> actual = itemController.findById(ITEM_ID_2);
        //then
        assertThat(actual.getStatusCode(), is(HttpStatus.NOT_FOUND));
        verify(mockItemService).findById(ITEM_ID_2);
    }

    @Test
    public void shouldReturnTheItemWhenItHasBeenFoundById(){
        //given
        Item item = new Item(2L, "Test Item", 100);
        when(mockItemService.findById(ITEM_ID_2)).thenReturn(Optional.of(item));
        //when
        ResponseEntity<Item> actual = itemController.findById(ITEM_ID_2);
        //then
        assertThat(actual.getStatusCode(), is(HttpStatus.OK));
        assertThat(actual.getBody(), is(item));
        verify(mockItemService).findById(ITEM_ID_2);
    }
}
