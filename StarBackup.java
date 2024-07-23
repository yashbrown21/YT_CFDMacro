public class StarBackup {
    // gets the simulation
    Simulation simulation_0 = 
      getActiveSimulation();

    // imports parts
    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    partImportManager_0.importCadPart(resolvePath("C:\\Users\\Yash\\Documents\\Academic Work and Files\\ICL [University]\\Extracurriculars\\ICAV\\2023 - Aero\\CAD\\ICAV_Phoenix_Final.step"), "SharpEdges", 30.0, 3, true, 1.0E-5, true, false, false, false, true, NeoProperty.fromString("{\'NX\': 0, \'STEP\': 0, \'SE\': 0, \'CGR\': 0, \'SW\': 0, \'IFC\': 0, \'ACIS\': 0, \'JT\': 0, \'IGES\': 0, \'CATIAV5\': 0, \'CATIAV4\': 0, \'CREO\': 0, \'INV\': 0}"), true, false);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Surface", 1);\
    
    // combines the part to allow for easier analysis later (this should be modified as needed for more specific star stuff)
    CompositePart compositePart_0 = 
      ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("LG_prop_assembly"));

    UnitePartsOperation unitePartsOperation_0 = 
      (UnitePartsOperation) simulation_0.get(MeshOperationManager.class).createUnitePartsOperation(new NeoObjectVector(new Object[] {compositePart_0}));

    unitePartsOperation_0.setPerformCADBoolean(true);

    unitePartsOperation_0.execute();

    // renaming parts
    unitePartsOperation_0.setPresentationName("Body");

    MeshOperationPart meshOperationPart_0 = 
      ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Unite"));

    meshOperationPart_0.setPresentationName("Body");

    Simulation simulation_0 = 
    getActiveSimulation();

  Scene scene_0 = 
    simulation_0.getSceneManager().getScene("Geometry Scene 1");

  CurrentView currentView_1 = 
    scene_0.getCurrentView();

  currentView_1.setInput(new DoubleVector(new double[] {-4.8901301240999855, -6.00001571017452, 3.8614106565602797}), new DoubleVector(new double[] {-15.194687328650069, -3.6080019114560407, 8.136231676093052}), new DoubleVector(new double[] {0.4248796139177489, 0.3110454778370702, 0.8501341214151099}), 1.4890317730165021, 0, 30.0);

  MeshOperationPart meshOperationPart_0 = 
    ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Body"));

  SurfaceWrapperAutoMeshOperation surfaceWrapperAutoMeshOperation_0 = 
    (SurfaceWrapperAutoMeshOperation) simulation_0.get(MeshOperationManager.class).createSurfaceWrapperAutoMeshOperation(new NeoObjectVector(new Object[] {meshOperationPart_0}), "Surface Wrapper");

  PartsTargetSurfaceSize partsTargetSurfaceSize_0 = 
    surfaceWrapperAutoMeshOperation_0.getDefaultValues().get(PartsTargetSurfaceSize.class);

  Units units_3 = 
    ((Units) simulation_0.getUnitsManager().getObject(""));

  partsTargetSurfaceSize_0.getRelativeSizeScalar().setValueAndUnits(2.0, units_3);

  PartsMinimumSurfaceSize partsMinimumSurfaceSize_0 = 
    surfaceWrapperAutoMeshOperation_0.getDefaultValues().get(PartsMinimumSurfaceSize.class);

  partsMinimumSurfaceSize_0.getRelativeSizeScalar().setValueAndUnits(1.0, units_3);

  SurfaceCurvature surfaceCurvature_0 = 
    surfaceWrapperAutoMeshOperation_0.getDefaultValues().get(SurfaceCurvature.class);

  surfaceCurvature_0.setEnableCurvatureDeviationDist(true);

  surfaceCurvature_0.setNumPointsAroundCircle(100.0);

  surfaceCurvature_0.setMaxNumPointsAroundCircle(360.0);

  surfaceWrapperAutoMeshOperation_0.execute();

  currentView_1.setInput(new DoubleVector(new double[] {-4.8901301240999855, -6.00001571017452, 3.8614106565602797}), new DoubleVector(new double[] {-15.194687328650069, -3.6080019114560407, 8.136231676093052}), new DoubleVector(new double[] {0.4248796139177489, 0.3110454778370702, 0.8501341214151099}), 1.4890317730165021, 0, 30.0);

  PartDisplayer partDisplayer_0 = 
    ((PartDisplayer) scene_0.getDisplayerManager().getObject("Outline 1"));

  CompositePart compositePart_0 = 
    ((CompositePart) simulation_0.get(SimulationPartManager.class).getPart("LG_prop_assembly"));

  CadPart cadPart_0 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Body23"));

  PartSurface partSurface_0 = 
    ((PartSurface) cadPart_0.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_1 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Body22"));

  PartSurface partSurface_1 = 
    ((PartSurface) cadPart_1.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_2 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Body21"));

  PartSurface partSurface_2 = 
    ((PartSurface) cadPart_2.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_3 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Body20"));

  PartSurface partSurface_3 = 
    ((PartSurface) cadPart_3.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_4 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Winglet (1)"));

  PartSurface partSurface_4 = 
    ((PartSurface) cadPart_4.getPartSurfaceManager().getPartSurface("ColoredFace1"));

  CadPart cadPart_5 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Winglet"));

  PartSurface partSurface_5 = 
    ((PartSurface) cadPart_5.getPartSurfaceManager().getPartSurface("ColoredFace1"));

  CadPart cadPart_6 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Prop port"));

  PartSurface partSurface_6 = 
    ((PartSurface) cadPart_6.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_7 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Prop starboard"));

  PartSurface partSurface_7 = 
    ((PartSurface) cadPart_7.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_8 = 
    ((CadPart) compositePart_0.getChildParts().getPart("LG_main"));

  PartSurface partSurface_8 = 
    ((PartSurface) cadPart_8.getPartSurfaceManager().getPartSurface("ColoredFace1"));

  PartSurface partSurface_9 = 
    ((PartSurface) cadPart_8.getPartSurfaceManager().getPartSurface("ColoredFace2"));

  CadPart cadPart_9 = 
    ((CadPart) compositePart_0.getChildParts().getPart("LG_rear_port"));

  PartSurface partSurface_10 = 
    ((PartSurface) cadPart_9.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_10 = 
    ((CadPart) compositePart_0.getChildParts().getPart("LG_rear_starboard"));

  PartSurface partSurface_11 = 
    ((PartSurface) cadPart_10.getPartSurfaceManager().getPartSurface("Faces"));

  CadPart cadPart_11 = 
    ((CadPart) compositePart_0.getChildParts().getPart("Body10"));

  PartSurface partSurface_12 = 
    ((PartSurface) cadPart_11.getPartSurfaceManager().getPartSurface("ColoredFace1"));

  partDisplayer_0.getHiddenParts().addObjects(partSurface_0, partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12);

  PartDisplayer partDisplayer_1 = 
    ((PartDisplayer) scene_0.getDisplayerManager().getObject("Surface 1"));

  partDisplayer_1.getHiddenParts().addObjects(partSurface_0, partSurface_1, partSurface_2, partSurface_3, partSurface_4, partSurface_5, partSurface_6, partSurface_7, partSurface_8, partSurface_9, partSurface_10, partSurface_11, partSurface_12);

  MeshOperationPart meshOperationPart_1 = 
    ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Surface Wrapper"));

  PartSurface partSurface_13 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body23.Faces"));

  PartSurface partSurface_14 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body22.Faces"));

  PartSurface partSurface_15 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body21.Faces"));

  PartSurface partSurface_16 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body20.Faces"));

  PartSurface partSurface_17 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Winglet (1).ColoredFace1"));

  PartSurface partSurface_18 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Winglet.ColoredFace1"));

  PartSurface partSurface_19 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_main.ColoredFace2"));

  PartSurface partSurface_20 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_rear_port.Faces"));

  PartSurface partSurface_21 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_rear_starboard.Faces"));

  PartSurface partSurface_22 = 
    ((PartSurface) meshOperationPart_1.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body10.ColoredFace1"));

  partDisplayer_0.getVisibleParts().addParts(partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22);

  partDisplayer_0.getHiddenParts().addParts();

  partDisplayer_1.getVisibleParts().addParts(partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21, partSurface_22);

  partDisplayer_1.getHiddenParts().addParts();

  currentView_1.setInput(new DoubleVector(new double[] {0.8192891763107599, -7.044169645386591, 1.4147818945075827}), new DoubleVector(new double[] {-13.178731931997897, -8.074391318964341, 8.410353999027913}), new DoubleVector(new double[] {0.4061365874558188, 0.3125480339566662, 0.8587006456266298}), 1.4890317730165021, 0, 30.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8192891763107599, -7.044169645386591, 1.4147818945075827}), new DoubleVector(new double[] {-13.178731931997897, -8.074391318964341, 8.410353999027913}), new DoubleVector(new double[] {0.4061365874558188, 0.3125480339566662, 0.8587006456266298}), 1.4890317730165021, 0, 27.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8192891763107599, -7.044169645386591, 1.4147818945075827}), new DoubleVector(new double[] {-13.178731931997897, -8.074391318964341, 8.410353999027913}), new DoubleVector(new double[] {0.4061365874558188, 0.3125480339566662, 0.8587006456266298}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-2.0270890687167076, 3.3081222177926195, 6.5115603476167525}), new DoubleVector(new double[] {8.906765173186159, 15.345303676018071, 4.954933078716586}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-2.697005529402107, 3.513258805012377, 7.829556473213119}), new DoubleVector(new double[] {10.64699390210825, 18.20379143713509, 5.9298024677433725}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-3.028702238254464, 3.691238981238584, 8.581242328474339}), new DoubleVector(new double[] {11.649697121057688, 19.85082485967545, 6.491512924642853}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-3.393568589043946, 3.887017205197324, 9.408096762858559}), new DoubleVector(new double[] {12.752670658654184, 21.662561619134884, 7.1093944254128285}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-3.794921606097926, 4.102373216569731, 10.317636644278293}), new DoubleVector(new double[] {13.965941548810836, 23.655472052569984, 7.7890640755878495}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-3.219145076323098, 3.362683556831186, 8.4541482760662}), new DoubleVector(new double[] {11.430205372344357, 19.49028922034494, 6.368554497737025}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-2.1787470385717125, 2.921163329450156, 6.247815215455119}), new DoubleVector(new double[] {8.500629348509463, 14.678187759072713, 4.727417363865871}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-0.5561852995238334, 2.0470000091987686, 2.5662036425643295}), new DoubleVector(new double[] {3.589173168264394, 6.610663561153554, 1.9760386479007124}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {-0.37602721375272985, 1.657051661157889, 1.7775481496645225}), new DoubleVector(new double[] {2.503141092505426, 4.826754730582521, 1.3676476883890694}), new DoubleVector(new double[] {0.7072304567370248, -0.5925336747280507, 0.38565389324735894}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.14532429693610951, 0.9706952958582533, 1.143913960000662}), new DoubleVector(new double[] {-3.2873451151983524, 0.42763408922690194, 3.068960489531843}), new DoubleVector(new double[] {0.4640618024812582, 0.15698054541779174, 0.871781940532277}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.21181139724501977, 0.978296979584302, 1.0994973658761407}), new DoubleVector(new double[] {-3.598118854625777, -0.47739403415968207, 1.1509867463276506}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.25916076535364585, 0.9434797355946051, 1.096866489817575}), new DoubleVector(new double[] {-3.961655232572725, -0.6692017343171509, 1.1539087941028927}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.3114137412881197, 0.9048328754273532, 1.0939547301681065}), new DoubleVector(new double[] {-4.364378439215218, -0.8816850420465646, 1.15714581939498}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.36909656652165523, 0.8619454794749539, 1.090731945698191}), new DoubleVector(new double[] {-4.810493455034883, -1.1170625733773356, 1.1607316211704164}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.4327919919204444, 0.8143625481835817, 1.0871647602472556}), new DoubleVector(new double[] {-5.304656489017431, -1.3777910198297065, 1.1647036252988898}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.5699714741766879, 0.6118550361730879, 1.0757180367330799}), new DoubleVector(new double[] {-7.056230492223885, -2.3019499254885782, 1.1787824994631366}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.662873061802479, 0.5414715649118662, 1.0704782266259052}), new DoubleVector(new double[] {-7.783731535314747, -2.685791297087933, 1.1846300375182144}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.7655658621831911, 0.4634417424390813, 1.0646775804194522}), new DoubleVector(new double[] {-8.589475716726787, -3.110915019849069, 1.1911064815153893}), new DoubleVector(new double[] {0.0019918541510425725, 0.03014173850601078, 0.9995436499307695}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8641658134030341, 0.5074144863989731, 1.0417178245838996}), new DoubleVector(new double[] {-7.282137688572014, -3.736712053490467, 5.036566894684955}), new DoubleVector(new double[] {0.352432639180513, 0.1866947995549014, 0.9170257829851152}), 1.4890317730165021, 0, 25.0);

  SimpleBlockPart simpleBlockPart_0 = 
    ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

  SubtractPartsOperation subtractPartsOperation_0 = 
    (SubtractPartsOperation) simulation_0.get(MeshOperationManager.class).createSubtractPartsOperation(new NeoObjectVector(new Object[] {simpleBlockPart_0, meshOperationPart_0}));

  subtractPartsOperation_0.getTargetPartManager().setQuery(null);

  subtractPartsOperation_0.getTargetPartManager().setObjects(simpleBlockPart_0);

  subtractPartsOperation_0.setPerformCADBoolean(true);

  subtractPartsOperation_0.execute();

  currentView_1.setInput(new DoubleVector(new double[] {0.8641658134030341, 0.5074144863989731, 1.0417178245838996}), new DoubleVector(new double[] {-7.282137688572014, -3.736712053490467, 5.036566894684955}), new DoubleVector(new double[] {0.352432639180513, 0.1866947995549014, 0.9170257829851152}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8641658134030341, 0.5074144863989731, 1.0417178245838996}), new DoubleVector(new double[] {-7.282137688572014, -3.736712053490467, 5.036566894684955}), new DoubleVector(new double[] {0.352432639180513, 0.1866947995549014, 0.9170257829851152}), 1.4890317730165021, 0, 25.0);

  partDisplayer_0.getHiddenParts().addObjects(partSurface_22);

  partDisplayer_1.getHiddenParts().addObjects(partSurface_22);

  MeshOperationPart meshOperationPart_2 = 
    ((MeshOperationPart) simulation_0.get(SimulationPartManager.class).getPart("Subtract"));

  PartSurface partSurface_23 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body23.Faces"));

  PartSurface partSurface_24 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body20.Faces"));

  PartSurface partSurface_25 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Winglet (1).ColoredFace1"));

  PartSurface partSurface_26 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Prop starboard.Faces"));

  PartSurface partSurface_27 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_main.ColoredFace1"));

  PartSurface partSurface_28 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_main.ColoredFace2"));

  PartSurface partSurface_29 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.LG_rear_starboard.Faces"));

  PartSurface partSurface_30 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Body.LG_prop_assembly.Body10.ColoredFace1"));

  PartSurface partSurface_31 = 
    ((PartSurface) meshOperationPart_2.getPartSurfaceManager().getPartSurface("Block.Block Surface"));

  partDisplayer_0.getVisibleParts().addParts(partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31);

  partDisplayer_0.getHiddenParts().addParts();

  partDisplayer_1.getVisibleParts().addParts(partSurface_23, partSurface_24, partSurface_25, partSurface_26, partSurface_27, partSurface_28, partSurface_29, partSurface_30, partSurface_31);

  partDisplayer_1.getHiddenParts().addParts();

  scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.MAKE_SCENE_TRANSPARENT);

  currentView_1.setInput(new DoubleVector(new double[] {0.8641658134030341, 0.5074144863989731, 1.0417178245838996}), new DoubleVector(new double[] {-7.282137688572014, -3.736712053490467, 5.036566894684955}), new DoubleVector(new double[] {0.352432639180513, 0.1866947995549014, 0.9170257829851152}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8641658134030341, 0.5074144863989731, 1.0417178245838996}), new DoubleVector(new double[] {-7.282137688572014, -3.736712053490467, 5.036566894684955}), new DoubleVector(new double[] {0.352432639180513, 0.1866947995549014, 0.9170257829851152}), 1.4890317730165021, 0, 25.0);

  PartSurface partSurface_32 = 
    ((PartSurface) simpleBlockPart_0.getPartSurfaceManager().getPartSurface("Block Surface"));

  simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_32, new IntVector(new int[] {4854}), "Symmetry");

  simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_32, new IntVector(new int[] {4853}), "Top");

  simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_32, new IntVector(new int[] {4855}), "Inlet");

  simpleBlockPart_0.splitPartSurfaceByPatch(partSurface_32, new IntVector(new int[] {4856, 4857}), "Freestream");

  scene_0.setTransparencyOverrideMode(SceneTransparencyOverride.USE_DISPLAYER_PROPERTY);

  partSurface_32.setPresentationName("Pressure Outlet");

  simulation_0.get(SimulationPartManager.class).updateParts(new NeoObjectVector(new Object[] {meshOperationPart_2}));

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

  simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshOperationPart_2}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_1, RegionManager.CreateInterfaceMode.BOUNDARY, "OneEdgeBoundaryPerPart", null);

  AutoMeshOperation autoMeshOperation_0 = 
    simulation_0.get(MeshOperationManager.class).createAutoMeshOperation(new StringVector(new String[] {"star.resurfacer.ResurfacerAutoMesher", "star.trimmer.TrimmerAutoMesher", "star.prismmesher.PrismAutoMesher"}), new NeoObjectVector(new Object[] {}));

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 25.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 22.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 18.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 21.0);

  currentView_1.setInput(new DoubleVector(new double[] {0.8809450567575504, 0.5177630330657584, 1.0345796225784096}), new DoubleVector(new double[] {-6.937494318263247, -5.0843213854998, 3.8314255550221525}), new DoubleVector(new double[] {0.2532157750980246, 0.12550307342416778, 0.9592344602872959}), 1.4890317730165021, 0, 22.0);

  partDisplayer_0.getHiddenParts().addObjects(partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21);

  partDisplayer_1.getHiddenParts().addObjects(partSurface_13, partSurface_14, partSurface_15, partSurface_16, partSurface_17, partSurface_18, partSurface_19, partSurface_20, partSurface_21);

  autoMeshOperation_0.getMeshers().setMeshersByNames(new StringVector(new String[] {"star.resurfacer.ResurfacerAutoMesher", "star.trimmer.TrimmerAutoMesher", "star.prismmesher.PrismAutoMesher", "star.resurfacer.AutomaticSurfaceRepairAutoMesher"}));

  autoMeshOperation_0.getInputGeometryObjects().setQuery(null);

  autoMeshOperation_0.getInputGeometryObjects().setObjects(meshOperationPart_2);

  autoMeshOperation_0.execute();

  PhysicsContinuum physicsContinuum_0 = 
    simulation_0.getContinuumManager().createContinuum(PhysicsContinuum.class);

  simulation_0.getContinuumManager().remove(physicsContinuum_0);

  PhysicsContinuum physicsContinuum_1 = 
    ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

  physicsContinuum_1.enable(SingleComponentGasModel.class);

  physicsContinuum_1.enable(CoupledFlowModel.class);

  physicsContinuum_1.enable(TurbulentModel.class);

  physicsContinuum_1.enable(RansTurbulenceModel.class);

  physicsContinuum_1.enable(KOmegaTurbulence.class);

  physicsContinuum_1.enable(SstKwTurbModel.class);

  physicsContinuum_1.enable(KwAllYplusWallTreatment.class);

  physicsContinuum_1.enable(GammaTransitionModel.class);

  physicsContinuum_1.enable(SteadyModel.class);

  GammaTransitionModel gammaTransitionModel_0 = 
    physicsContinuum_1.getModelManager().getModel(GammaTransitionModel.class);

  physicsContinuum_1.disableModel(gammaTransitionModel_0);

  physicsContinuum_1.enable(RealGasModel.class);

  physicsContinuum_1.enable(CoupledEnergyModel.class);

  RealGasModel realGasModel_0 = 
    physicsContinuum_1.getModelManager().getModel(RealGasModel.class);

  physicsContinuum_1.disableModel(realGasModel_0);

  physicsContinuum_1.enable(IdealGasModel.class);

  IdealGasModel idealGasModel_0 = 
    physicsContinuum_1.getModelManager().getModel(IdealGasModel.class);

  physicsContinuum_1.disableModel(idealGasModel_0);

  physicsContinuum_1.enable(PolynomialDensityModel.class);

  PolynomialDensityModel polynomialDensityModel_0 = 
    physicsContinuum_1.getModelManager().getModel(PolynomialDensityModel.class);

  physicsContinuum_1.disableModel(polynomialDensityModel_0);

  physicsContinuum_1.enable(ThermalNeqIdealGasModel.class);

  physicsContinuum_1.enable(CoupledThermalNeqModel.class);

  CoupledThermalNeqModel coupledThermalNeqModel_0 = 
    physicsContinuum_1.getModelManager().getModel(CoupledThermalNeqModel.class);

  physicsContinuum_1.disableModel(coupledThermalNeqModel_0);

  ThermalNeqIdealGasModel thermalNeqIdealGasModel_0 = 
    physicsContinuum_1.getModelManager().getModel(ThermalNeqIdealGasModel.class);

  physicsContinuum_1.disableModel(thermalNeqIdealGasModel_0);

  physicsContinuum_1.enable(UserDefinedEosModel.class);

  physicsContinuum_1.enable(AmrModel.class);

  UserDefinedEosModel userDefinedEosModel_0 = 
    physicsContinuum_1.getModelManager().getModel(UserDefinedEosModel.class);

  physicsContinuum_1.disableModel(userDefinedEosModel_0);

  physicsContinuum_1.enable(RealGasModel.class);

  physicsContinuum_1.enable(RedlichKwongEosModel.class);

  SingleComponentGasModel singleComponentGasModel_0 = 
    physicsContinuum_1.getModelManager().getModel(SingleComponentGasModel.class);

  Gas gas_0 = 
    ((Gas) singleComponentGasModel_0.getMaterial());

  ConstantMaterialPropertyMethod constantMaterialPropertyMethod_0 = 
    ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(DynamicViscosityProperty.class).getMethod());

  Units units_4 = 
    ((Units) simulation_0.getUnitsManager().getObject("Pa-s"));

  constantMaterialPropertyMethod_0.getQuantity().setValueAndUnits(1.85E-5, units_4);

  ConstantMaterialPropertyMethod constantMaterialPropertyMethod_1 = 
    ((ConstantMaterialPropertyMethod) gas_0.getMaterialProperties().getMaterialProperty(TurbulentPrandtlNumberProperty.class).getMethod());

  constantMaterialPropertyMethod_1.getQuantity().setValueAndUnits(0.89, units_3);

  VelocityProfile velocityProfile_0 = 
    physicsContinuum_1.getInitialConditions().get(VelocityProfile.class);

  velocityProfile_0.setMethod(XyzTabularVectorProfileMethod.class);

  velocityProfile_0.setMethod(ConstantVectorProfileMethod.class);

  Units units_5 = 
    ((Units) simulation_0.getUnitsManager().getObject("m/s"));

  velocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(5.0, 12.0, 0.0, units_5);

  physicsContinuum_1.getInitialConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

  TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_0 = 
    physicsContinuum_1.getInitialConditions().get(TurbulentKineticEnergyProfile.class);

  Units units_6 = 
    ((Units) simulation_0.getUnitsManager().getObject("J/kg"));

  turbulentKineticEnergyProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.32, units_6);

  SpecificDissipationRateProfile specificDissipationRateProfile_0 = 
    physicsContinuum_1.getInitialConditions().get(SpecificDissipationRateProfile.class);

  Units units_7 = 
    ((Units) simulation_0.getUnitsManager().getObject("/s"));

  specificDissipationRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(43.4, units_7);

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
    region_0.getBoundaryManager().getBoundary("Subtract.Block.Pressure Outlet");

  PressureBoundary pressureBoundary_0 = 
    ((PressureBoundary) simulation_0.get(ConditionTypeManager.class).get(PressureBoundary.class));

  boundary_3.setBoundaryType(pressureBoundary_0);

  Boundary boundary_4 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Block.Symmetry");

  SymmetryBoundary symmetryBoundary_0 = 
    ((SymmetryBoundary) simulation_0.get(ConditionTypeManager.class).get(SymmetryBoundary.class));

  boundary_4.setBoundaryType(symmetryBoundary_0);

  Boundary boundary_5 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Block.Top");

  boundary_5.setBoundaryType(freeStreamBoundary_0);

  MeshManager meshManager_0 = 
    simulation_0.getMeshManager();

  Boundary boundary_6 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Body10.ColoredFace1");

  Boundary boundary_7 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Body20.Faces");

  Boundary boundary_8 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Body23.Faces");

  Boundary boundary_9 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.LG_main.ColoredFace1");

  Boundary boundary_10 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.LG_main.ColoredFace2");

  Boundary boundary_11 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.LG_rear_starboard.Faces");

  Boundary boundary_12 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Prop starboard.Faces");

  Boundary boundary_13 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Winglet (1).ColoredFace1");

  meshManager_0.combineBoundaries(new NeoObjectVector(new Object[] {boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_13}));

  boundary_1.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.INTENSITY_LENGTH_SCALE);

  FlowDirectionProfile flowDirectionProfile_0 = 
    boundary_1.getValues().get(FlowDirectionProfile.class);

  flowDirectionProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(5.0, 12.0, 0.0, units_3);

  MachNumberProfile machNumberProfile_0 = 
    boundary_1.getValues().get(MachNumberProfile.class);

  machNumberProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.1, units_3);

  boundary_1.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

  SpecificDissipationRateProfile specificDissipationRateProfile_1 = 
    boundary_1.getValues().get(SpecificDissipationRateProfile.class);

  specificDissipationRateProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(43.4, units_7);

  TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_1 = 
    boundary_1.getValues().get(TurbulentKineticEnergyProfile.class);

  turbulentKineticEnergyProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.54, units_6);

  boundary_2.getConditions().get(InletVelocityOption.class).setSelected(InletVelocityOption.Type.COMPONENTS);

  boundary_2.getConditions().get(KwTurbSpecOption.class).setSelected(KwTurbSpecOption.Type.K_OMEGA);

  SpecificDissipationRateProfile specificDissipationRateProfile_2 = 
    boundary_2.getValues().get(SpecificDissipationRateProfile.class);

  specificDissipationRateProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(43.4, units_7);

  TurbulentKineticEnergyProfile turbulentKineticEnergyProfile_2 = 
    boundary_2.getValues().get(TurbulentKineticEnergyProfile.class);

  turbulentKineticEnergyProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(0.54, units_6);

  StaticTemperatureProfile staticTemperatureProfile_0 = 
    boundary_2.getValues().get(StaticTemperatureProfile.class);

  Units units_8 = 
    ((Units) simulation_0.getUnitsManager().getObject("K"));

  staticTemperatureProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValueAndUnits(500.0, units_8);

  VelocityProfile velocityProfile_1 = 
    boundary_2.getValues().get(VelocityProfile.class);

  velocityProfile_1.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponentsAndUnits(5.0, 12.0, 0.0, units_5);

  AmrSolver amrSolver_0 = 
    ((AmrSolver) simulation_0.getSolverManager().getSolver(AmrSolver.class));

  AmrStarUpdate amrStarUpdate_0 = 
    amrSolver_0.getAmrTrigger();

  IterationUpdateFrequency iterationUpdateFrequency_0 = 
    amrStarUpdate_0.getIterationUpdateFrequency();

  iterationUpdateFrequency_0.setIterations(50);

  KwTurbViscositySolver kwTurbViscositySolver_0 = 
    ((KwTurbViscositySolver) simulation_0.getSolverManager().getSolver(KwTurbViscositySolver.class));

  kwTurbViscositySolver_0.getViscosityUrfQuantity().setValueAndUnits(0.355, units_3);

  ResidualMonitor residualMonitor_0 = 
    ((ResidualMonitor) simulation_0.getMonitorManager().getMonitor("Y-momentum"));

  MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = 
    simulation_0.getSolverStoppingCriterionManager().createIterationStoppingCriterion(residualMonitor_0);

  ((MonitorIterationStoppingCriterionOption) monitorIterationStoppingCriterion_0.getCriterionOption()).setSelected(MonitorIterationStoppingCriterionOption.Type.RELATIVE_CHANGE);

  MonitorIterationStoppingCriterionRelativeChangeType monitorIterationStoppingCriterionRelativeChangeType_0 = 
    ((MonitorIterationStoppingCriterionRelativeChangeType) monitorIterationStoppingCriterion_0.getCriterionType());

  monitorIterationStoppingCriterionRelativeChangeType_0.setEnableSamplingRefresh(true);

  Simulation simulation_0 = 
    getActiveSimulation();

  MonitorIterationStoppingCriterion monitorIterationStoppingCriterion_0 = 
    ((MonitorIterationStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Y-momentum Criterion"));

  MonitorIterationStoppingCriterionRelativeChangeType monitorIterationStoppingCriterionRelativeChangeType_0 = 
    ((MonitorIterationStoppingCriterionRelativeChangeType) monitorIterationStoppingCriterion_0.getCriterionType());

  monitorIterationStoppingCriterionRelativeChangeType_0.setEnableSamplingRefresh(false);

  monitorIterationStoppingCriterion_0.getLogicalOption().setSelected(SolverStoppingCriterionLogicalOption.Type.AND);

  ((MonitorIterationStoppingCriterionOption) monitorIterationStoppingCriterion_0.getCriterionOption()).setSelected(MonitorIterationStoppingCriterionOption.Type.ASYMPTOTIC);

  ((MonitorIterationStoppingCriterionOption) monitorIterationStoppingCriterion_0.getCriterionOption()).setSelected(MonitorIterationStoppingCriterionOption.Type.STANDARD_DEVIATION);

  MonitorIterationStoppingCriterionStandardDeviationType monitorIterationStoppingCriterionStandardDeviationType_0 = 
    ((MonitorIterationStoppingCriterionStandardDeviationType) monitorIterationStoppingCriterion_0.getCriterionType());

  monitorIterationStoppingCriterionStandardDeviationType_0.setNumberSamples(500);

  HeatTransferReport heatTransferReport_0 = 
    simulation_0.getReportManager().createReport(HeatTransferReport.class);

  heatTransferReport_0.getParts().setQuery(null);

  Region region_0 = 
    simulation_0.getRegionManager().getRegion("Region");

  Boundary boundary_6 = 
    region_0.getBoundaryManager().getBoundary("Subtract.Body.LG_prop_assembly.Body10.ColoredFace1");

  heatTransferReport_0.getParts().setObjects(boundary_6);

  simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {heatTransferReport_0}), true, "%1$s Plot");

  ReportMonitor reportMonitor_0 = 
    ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Heat Transfer 1 Monitor"));

  MonitorPlot monitorPlot_0 = 
    simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "Heat Transfer 1 Monitor Plot");

  monitorPlot_0.openInteractive();

  PlotUpdate plotUpdate_0 = 
    monitorPlot_0.getPlotUpdate();

  HardcopyProperties hardcopyProperties_2 = 
    plotUpdate_0.getHardcopyProperties();

  hardcopyProperties_2.setCurrentResolutionWidth(25);

  hardcopyProperties_2.setCurrentResolutionHeight(25);

  Scene scene_0 = 
    simulation_0.getSceneManager().getScene("Geometry Scene 1");

  SceneUpdate sceneUpdate_0 = 
    scene_0.getSceneUpdate();

  HardcopyProperties hardcopyProperties_0 = 
    sceneUpdate_0.getHardcopyProperties();

  hardcopyProperties_0.setCurrentResolutionWidth(1048);

  hardcopyProperties_0.setCurrentResolutionHeight(430);

  hardcopyProperties_2.setCurrentResolutionWidth(1046);

  hardcopyProperties_2.setCurrentResolutionHeight(429);

  MeshPipelineController meshPipelineController_0 = 
    simulation_0.get(MeshPipelineController.class);

  meshPipelineController_0.generateVolumeMesh();

  ResidualPlot residualPlot_0 = 
    ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

  residualPlot_0.openInteractive();

  PlotUpdate plotUpdate_1 = 
    residualPlot_0.getPlotUpdate();

  HardcopyProperties hardcopyProperties_3 = 
    plotUpdate_1.getHardcopyProperties();

  hardcopyProperties_3.setCurrentResolutionWidth(25);

  hardcopyProperties_3.setCurrentResolutionHeight(25);

  simulation_0.getSimulationIterator().run();

  hardcopyProperties_2.setCurrentResolutionWidth(1048);

  hardcopyProperties_2.setCurrentResolutionHeight(430);

  hardcopyProperties_3.setCurrentResolutionWidth(1046);

  hardcopyProperties_3.setCurrentResolutionHeight(429);

  hardcopyProperties_2.setCurrentResolutionWidth(1046);

  hardcopyProperties_2.setCurrentResolutionHeight(429);

  Cartesian2DAxisManager cartesian2DAxisManager_0 = 
    ((Cartesian2DAxisManager) monitorPlot_0.getAxisManager());

  cartesian2DAxisManager_0.setAxesBounds(new Vector(Arrays.<AxisManager.AxisBounds>asList(new AxisManager.AxisBounds("Left Axis", -0.5, false, 0.5, false), new AxisManager.AxisBounds("Bottom Axis", 1.0, false, 500.0, false))));

  monitorPlot_0.export(resolvePath("C:\\Users\\Yash\\Documents\\yeet.csv"), ",");
}