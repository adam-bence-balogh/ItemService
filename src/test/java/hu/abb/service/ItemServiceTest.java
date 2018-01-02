package hu.abb.service;

import hu.abb.entity.Item;
import hu.abb.repository.ItemRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * @author: Balogh Ádám Bence
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
    private static final String ITEM_NAME_1 = "TEST_ITEM1";
    private static final String ITEM_NAME_2 = "TEST_ITEM2";
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository mockItemRepository;

    @Test
    public void shouldReturnTheMostExpensiveItem(){
        //given
        Item expensiveItem = new Item(1L, ITEM_NAME_1, 500);
        Item cheapItem = new Item(2L, ITEM_NAME_2, 100);
        when(mockItemRepository.findAll()).thenReturn(Arrays.asList(expensiveItem, cheapItem));
        //when
        Item actual = itemService.findMostExpensive().get();
        //then
        assertThat(actual, is(expensiveItem));
    }
}
