// Simcenter STAR-CCM+ macro: StarBackup2.java
// Written by Simcenter STAR-CCM+ 17.04.008
package macro;

import java.util.*;

import star.base.neo.*;
import star.realgas.*;
import star.turbulence.*;
import star.kwturb.*;
import star.energy.*;
import star.flow.*;
import star.metrics.*;
import star.meshing.*;
import star.common.*;
import star.material.*;
import star.coupledflow.*;
import star.prismmesher.*;
import star.vis.*;

public class StarBackup2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("C:\\Users\\Yash\\Documents\\Academic Work and Files\\ICL [University]\\Extracurriculars\\ICAV\\2023 - Aero\\CAD\\Phoenix Iteration 4 v2.step"), "SharpEdges", 30.0, 4, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 0, \'STEP\': 0, \'SE\': 0, \'CGR\': 0, \'SW\': 0, \'IFC\': 0, \'ACIS\': 0, \'JT\': 0, \'IGES\': 0, \'CATIAV5\': 0, \'CATIAV4\': 0, \'CREO\': 0, \'INV\': 0}"), true, false);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Surface", 1);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    scene_0.initializeAndWait();

    SceneUpdate sceneUpdate_0 = 
      scene_0.getSceneUpdate();

    HardcopyProperties hardcopyProperties_0 = 
      sceneUpdate_0.getHardcopyProperties();

    hardcopyProperties_0.setCurrentResolutionWidth(25);

    hardcopyProperties_0.setCurrentResolutionHeight(25);

    hardcopyProperties_0.setCurrentResolutionWidth(1061);

    hardcopyProperties_0.setCurrentResolutionHeight(440);

    scene_0.resetCamera();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(Dimensions.Builder().length(1).build());

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    SimpleBlockPart simpleBlockPart_0 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_0.setDoNotRetessellate(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    simpleBlockPart_0.setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner1().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner1().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, -1.0, -0.5}));

    simpleBlockPart_0.getCorner2().setCoordinateSystem(labCoordinateSystem_0);

    simpleBlockPart_0.getCorner2().setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {2.0, 3.0, 0.5}));

    simpleBlockPart_0.rebuildSimpleShapePart();

    simpleBlockPart_0.setDoNotRetessellate(false);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-0.007166507845002501, 0.6250981937916114, -0.004289508311141204}), new DoubleVector(new double[] {2.948368435055942, -3.5723218723563797, 1.6138747587263307}), new DoubleVector(new double[] {0.3292201003007193, 0.5324450287753781, 0.7798181947674694}), 1.3931096554057576, 0, 30.0);

    PartSurface partSurface_0 = 
      ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));

    simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {155, 159, 160}), "Freestream");

    simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {156}), "Inlet");

    simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_0, new IntVector(new int[] {158}), "Outlet");

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

    partSurface_0.setPresentationName("Symmetry");

    CadPart cadPart_0 = 
      ((CadPart) simulation_0.get(SimulationPartManager.class).getPart("Body1"));

    SubtractPartsOperation subtractPartsOperation_0 = 
      (SubtractPartsOperation) simulation_0.get(MeshOperationManager.class).createSubtractPartsOperation(new NeoObjectVector(new Object[] {simpleBlockPart_0, cadPart_0}));

    subtractPartsOperation_0.getTargetPartManager().setQuery(null);

    subtractPartsOperation_0.getTargetPartManager().setObjects(simpleBlockPart_0);

    subtractPartsOperation_0.setPerformCADBoolean(true);

    subtractPartsOperation_0.execute();

    Region region_0 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_0.setPresentationName("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Default");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0}));

    FeatureCurve featureCurve_0 = 
      ((FeatureCurve) region_0.getFeatureCurveManager().getObject("Default"));

    region_0.getFeatureCurveManager().removeObjects(featureCurve_0);

    FeatureCurve featureCurve_1 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshOperationPart meshOperationPart_0 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Subtract"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshOperationPart_0}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_1, RegionManager.CreateInterfaceMode.BOUNDARY, "OneEdgeBoundaryPerPart", null);

    PhysicsContinuum physicsContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

    physicsContinuum_0.enable(ThreeDimensionalModel.class);

    physicsContinuum_0.enable(SingleComponentGasModel.class);

    physicsContinuum_0.enable(CoupledFlowModel.class);

    physicsContinuum_0.enable(SteadyModel.class);

    physicsContinuum_0.enable(TurbulentModel.class);

    physicsContinuum_0.enable(RansTurbulenceModel.class);

    physicsContinuum_0.enable(KOmegaTurbulence.class);

    physicsContinuum_0.enable(SstKwTurbModel.class);

    physicsContinuum_0.enable(KwAllYplusWallTreatment.class);

    physicsContinuum_0.enable(RealGasModel.class);

    physicsContinuum_0.enable(CoupledEnergyModel.class);

    physicsContinuum_0.enable(EquilibriumAirEosModel.class);

    AutoMeshOperation autoMeshOperation_0 = 
      simulation_0.get(MeshOperationManager.class).createAutoMeshOperation(new StringVector(new String[] {"star.resurfacer.ResurfacerAutoMesher", "star.resurfacer.AutomaticSurfaceRepairAutoMesher", "star.dualmesher.DualAutoMesher", "star.prismmesher.PrismAutoMesher"}), new NeoObjectVector(new Object[] {}));

    autoMeshOperation_0.getInputGeometryObjects().setQuery(null);

    autoMeshOperation_0.getInputGeometryObjects().setObjects(meshOperationPart_0);

    autoMeshOperation_0.execute();

    autoMeshOperation_0.getDefaultValues().get(BaseSize.class).setValueAndUnits(0.01, units_0);

    MeshPipelineController meshPipelineController_0 = 
      simulation_0.get(MeshPipelineController.class);

    meshPipelineController_0.generateVolumeMesh();

    SurfaceCustomMeshControl surfaceCustomMeshControl_0 = 
      autoMeshOperation_0.getCustomMeshControls().createSurfaceControl();

    surfaceCustomMeshControl_0.getGeometryObjects().setQuery(null);

    PartSurface partSurface_1 = 
      ((PartSurface) meshOperationPart_0.getPartSurfaceManager().getPartSurface("Body1.Faces"));

    surfaceCustomMeshControl_0.getGeometryObjects().setObjects(partSurface_1);

    PartsCustomizePrismMesh partsCustomizePrismMesh_0 = 
      surfaceCustomMeshControl_0.getCustomConditions().get(PartsCustomizePrismMesh.class);

    partsCustomizePrismMesh_0.getCustomPrismOptions().setSelected(PartsCustomPrismsOption.Type.CUSTOMIZE);

    PartsCustomizePrismMeshControls partsCustomizePrismMeshControls_0 = 
      partsCustomizePrismMesh_0.getCustomPrismControls();

    partsCustomizePrismMeshControls_0.setCustomizeNumLayers(true);

    partsCustomizePrismMeshControls_0.setCustomizeTotalThickness(true);

    partsCustomizePrismMeshControls_0.setCustomizeStretching(true);

    PrismThickness prismThickness_0 = 
      surfaceCustomMeshControl_0.getCustomValues().get(CustomPrismValuesManager.class).get(PrismThickness.class);

    prismThickness_0.getRelativeOrAbsoluteOption().setSelected(RelativeOrAbsoluteOption.Type.ABSOLUTE);

    ((ScalarPhysicalQuantity) prismThickness_0.getAbsoluteSizeValue()).setValueAndUnits(0.03, units_0);

    PrismLayerStretching prismLayerStretching_0 = 
      surfaceCustomMeshControl_0.getCustomValues().get(CustomPrismValuesManager.class).get(PrismLayerStretching.class);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject(""));

    prismLayerStretching_0.getStretchingQuantity().setValueAndUnits(1.2, units_1);

    NumPrismLayers numPrismLayers_0 = 
      surfaceCustomMeshControl_0.getCustomValues().get(CustomPrismValuesManager.class).get(NumPrismLayers.class);

    IntegerValue integerValue_0 = 
      numPrismLayers_0.getNumLayersValue();

    integerValue_0.getQuantity().setValue(16.0);

    partsCustomizePrismMeshControls_0.setOverrideBoundaryDefault(true);

    partsCustomizePrismMeshControls_0.setOverrideBoundaryDefault(false);

    PrismAutoMesher prismAutoMesher_0 = 
      ((PrismAutoMesher) autoMeshOperation_0.getMeshers().getObject("Prism Layer Mesher"));

    prismAutoMesher_0.getPrismStretchingOption().setSelected(PrismStretchingOption.Type.WALL_THICKNESS);

    prismAutoMesher_0.getPrismStretchingOption().setSelected(PrismStretchingOption.Type.STRETCHING);

    SstKwTurbModel sstKwTurbModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SstKwTurbModel.class);

    sstKwTurbModel_0.setA1(0.355);

    SingleComponentGasModel singleComponentGasModel_0 = 
      physicsContinuum_0.getModelManager().getModel(SingleComponentGasModel.class);

    Gas gas_0 = 
      ((Gas) singleComponentGasModel_0.getMaterial());

    ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = 
      ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());

    constantMaterialPropertyMethod_0.getQuantity().setValueAndUnits(0.89, units_1);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("Pa"));

    physicsContinuum_0.getReferenceValues().get(ReferencePressure.class).setValueAndUnits(105.0, units_2);

    StaticTemperatureProfile staticTemperatureProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(StaticTemperatureProfile.class);

    Units units_3 = 
      ((Units) simulation_0.getUnitsManager().getObject("K"));

    staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(600.0, units_3);

    physicsContinuum_0.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

    SpecificDissipationRateProfile specificDissipationRateProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(SpecificDissipationRateProfile.class);

    Units units_4 = 
      ((Units) simulation_0.getUnitsManager().getObject("/s"));

    specificDissipationRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(24.0, units_4);

    TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(TurbulentKineticEnergyProfile.class);

    Units units_5 = 
      ((Units) simulation_0.getUnitsManager().getObject("J/kg"));

    turbulentKineticEnergyProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.1, units_5);

    VelocityProfile velocityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

    Units units_6 = 
      ((Units) simulation_0.getUnitsManager().getObject("m/s"));

    velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(5.0, 1.0, -20.0, units_6);

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Block.Freestream");

    FreeStreamBoundary freeStreamBoundary_0 = 
      ((FreeStreamBoundary) simulation_0.get(ConditionTypeManager.class).get(FreeStreamBoundary.class));

    boundary_1.setBoundaryType(freeStreamBoundary_0);

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Block.Inlet");

    InletBoundary inletBoundary_0 = 
      ((InletBoundary) simulation_0.get(ConditionTypeManager.class).get(InletBoundary.class));

    boundary_2.setBoundaryType(inletBoundary_0);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Block.Outlet");

    PressureBoundary pressureBoundary_0 = 
      ((PressureBoundary) simulation_0.get(ConditionTypeManager.class).get(PressureBoundary.class));

    boundary_3.setBoundaryType(pressureBoundary_0);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Block.Symmetry");

    SymmetryBoundary symmetryBoundary_0 = 
      ((SymmetryBoundary) simulation_0.get(ConditionTypeManager.class).get(SymmetryBoundary.class));

    boundary_4.setBoundaryType(symmetryBoundary_0);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Body1.Faces");

    boundary_5.getConditions().get(WallThermalOption.class).setSelected(WallThermalOption.Type.HEAT_FLUX);

    boundary_3.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

    StaticTemperatureProfile staticTemperatureProfile_1 = 
      boundary_3.getValues().get(StaticTemperatureProfile.class);

    staticTemperatureProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(400.0, units_3);

    TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_1 = 
      boundary_3.getValues().get(TurbulentKineticEnergyProfile.class);

    turbulentKineticEnergyProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.1, units_5);

    SpecificDissipationRateProfile specificDissipationRateProfile_1 = 
      boundary_3.getValues().get(SpecificDissipationRateProfile.class);

    specificDissipationRateProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(24.0, units_4);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    scene_0.getCreatorGroup().setQuery(null);

    scene_0.getCreatorGroup().setObjects();

    scene_0.getCreatorGroup().setQuery(null);

    scene_0.getCreatorGroup().setObjects(boundary_5);

    PartDisplayer partDisplayer_0 = 
      scene_0.getDisplayerManager().createPartDisplayer("Cell Surface Displayer Surface", -1, 1);

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

    CellSurfacePart cellSurfacePart_0 = 
      simulation_0.getPartManager().createCellSurfacePart(new NeoObjectVector(new Object[] {boundary_5}));

    partDisplayer_0.getVisibleParts().addParts(cellSurfacePart_0);

    partDisplayer_0.getHiddenParts().addParts();

    scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);
  }
}
