package Collision;

public class CollisionType {
	
	//Bitcodes, um Fixtures zu kategorisieren und maskieren, was mit was kollidieren darf
	public static final short BIT_PLAYER = 2;
	public static final short BIT_ENEMY = 4; //Orks & Creeps
	
	public static final short BIT_CASTLE = 8;
	public static final short BIT_CAVE = 16;
	
	public static final short BIT_ENVIRONMENT = 32;
	
	public static final short BIT_SUPPORT_SPELL = 64;
	public static final short BIT_ATTACK_SPELLS = 128;


}
