package etiocook.espleef;

public class TesT {

    public static void main(String[] args) {
        for (int x = 0; x < 30; x++) {
            System.out.println("X: " + x);

            for (int z = 0; z < 30; z++) {
                System.out.println("z: " + z);
            }

            for (int y = 0; y < 30; y++) {
                System.out.println("Y: " + y);
            }

        }

    }

  /*  static void setBlocks(){
        for (int x = block.getX(); x < block.getX() + 6; x++) {
            for (int y = block.getY(); y < block.getY() + 5; y++) {
                Block locBlock = new Location(block.getWorld(), x, y, block.getZ()).getBlock();
                if (locBlock.getType() == Material.AIR) {
                    locBlock.setType(block.getType());
                }

                Location loc = e.getLightning().getLocation();
World w = loc.getWorld();
w.getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()).setType(Material.DIAMOND_ORE);
            }
        }
    }*/

}
