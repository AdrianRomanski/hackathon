package pl.pja.edu.hackathon.model.memocard;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WordEnum {

	//TODO add more

	//Colors
	BLUE(CategoryEnum.COLORS),
	GREEN(CategoryEnum.COLORS),
	RED(CategoryEnum.COLORS),
	YELLOW(CategoryEnum.COLORS),
	PINK(CategoryEnum.COLORS),
	PURPLE(CategoryEnum.COLORS),
	BROWN(CategoryEnum.COLORS),
	BLACK(CategoryEnum.COLORS),
	WHITE(CategoryEnum.COLORS),

	//Furniture
	OVEN(CategoryEnum.FURNITURE),
	CHAIR(CategoryEnum.FURNITURE),
	TABLE(CategoryEnum.FURNITURE),
	SHELF(CategoryEnum.FURNITURE),
	WARDROBE(CategoryEnum.FURNITURE),

	//Nature
	FLOWER(CategoryEnum.NATURE),
	GRASS(CategoryEnum.NATURE),
	TREE(CategoryEnum.NATURE),
	LEAF(CategoryEnum.NATURE),
	BUSH(CategoryEnum.NATURE),
	VINE(CategoryEnum.NATURE),
	SAPLING(CategoryEnum.NATURE);

	private final CategoryEnum categoryEnum;

}