package windmillcomplete;

public class Start {

	public static void main(String[] args) {

		IO io = new IO("en_climate_hourly_ON_6156177_12-2015_P1H.csv");

		WindFarm farm = new WindFarm(new EngineeringModelsProduction());
		farm.addWindGenerator(WindGenerator.build(123).installGearPackage(new GearPackage(GearModel.CYCLONE3, .5))
				.installGeneratorPackage(new GeneratorPackage(GeneratorModel.THUNDERBOLT7, "May 1012", 3, 40, 400)));

		farm.addWindGenerator(WindGenerator.build(456).installGearPackage(new GearPackage(GearModel.CYCLONE3, .54))
				.installGeneratorPackage(new GeneratorPackage(GeneratorModel.SPARKY1000, "Sept 2004", 5, 60, 400)));

		System.out.println(farm.generateWindFarmReport(io.getWindSpeeds()[1]));
		System.out.println(farm.findBestPerformer(80));
		System.out.println(farm.findBestPowerAvg(io.getWindSpeeds()));
	}

}
