package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        //when
        List<Item> result = itemRepository.findAll();


        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(itemA, itemB);

    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("itemA", 10000, 10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updateParam = new Item("itemB", 20000, 30);
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findById(itemId);

        //then
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }
}