public class StoneSlabUsage  {
    public static StoneSlabPair igneousCobblestoneSlab;
    
    
    private int igneousCobblestoneSlabHalfID;
    private int igneousCobblestoneSlabFullID;
 
     @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());   
        igneousCobblestoneSlabHalfID = config.get(blockCategory, "Igneous Stone Cobblestone Slab ID (half):", 219).getInt();
        igneousCobblestoneSlabFullID = config.get(blockCategory, "Igneous Stone Cobblestone Slab ID (full):", 220).getInt();
        igneousCobblestoneSlab = stoneSlabPair(igneousCobblestone,IDs.igneousCobblestoneSlabName);
        config.save();
    }

    public StoneSlabPair stoneSlabPair(BlockMetadataBase material, NamedSlabPair slabPairName) {
        BlockStoneSlab half = new BlockStoneSlab(false,material,slabPairName);
        BlockStoneSlab full = new BlockStoneSlab(true,material,slabPairName);

        GameRegistry.registerBlock(half,ItemMetadataSlab.class,slabPairName.half.internal(),IDs.ubPrefix(),full);
        GameRegistry.registerBlock(full,ItemMetadataSlab.class,slabPairName.full.internal(),IDs.ubPrefix(),half);

        return new StoneSlabPair(half,full);
    }
}
