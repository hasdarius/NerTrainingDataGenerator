/*
package modelData

import java.io.{File, PrintWriter}

object TrainingDataCreator extends App {


  val programmingLanguages ="""A# .NET,https://en.wikipedia.org/wiki/A_Sharp_(.NET)
                              |A# (Axiom),https://en.wikipedia.org/wiki/A_Sharp_(Axiom)
                              |A-0 System,https://en.wikipedia.org/wiki/A-0_System
                              |A+,https://en.wikipedia.org/wiki/A%2B_(programming_language)
                              |A++,https://en.wikipedia.org/wiki/A%2B%2B
                              |ABAP,https://en.wikipedia.org/wiki/ABAP
                              |ABC,https://en.wikipedia.org/wiki/ABC_(programming_language)
                              |ABC ALGOL,https://en.wikipedia.org/wiki/ABC_ALGOL
                              |ABSET,https://en.wikipedia.org/wiki/ABSET
                              |ABSYS,https://en.wikipedia.org/wiki/ABSYS
                              |ACC,https://en.wikipedia.org/wiki/ACC_(programming_language)
                              |Accent,https://en.wikipedia.org/wiki/Accent_(programming_language)
                              |Ace DASL,https://en.wikipedia.org/wiki/Distributed_Application_Specification_Language
                              |ACL2,https://en.wikipedia.org/wiki/ACL2
                              |ACT-III,https://en.wikipedia.org/wiki/LGP-30#ACT-III_programming_language
                              |Action!,https://en.wikipedia.org/wiki/Action!_(programming_language)
                              |ActionScript,https://en.wikipedia.org/wiki/ActionScript
                              |Ada,https://en.wikipedia.org/wiki/Ada_(programming_language)
                              |Adenine,https://en.wikipedia.org/wiki/Adenine_(programming_language)
                              |Agda,https://en.wikipedia.org/wiki/Agda_(theorem_prover)
                              |Agilent VEE,https://en.wikipedia.org/wiki/Agilent_VEE
                              |Agora,https://en.wikipedia.org/wiki/Agora_(programming_language)
                              |AIMMS,https://en.wikipedia.org/wiki/AIMMS
                              |Alef,https://en.wikipedia.org/wiki/Alef_(programming_language)
                              |ALF,https://en.wikipedia.org/wiki/Algebraic_Logic_Functional_programming_language
                              |ALGOL 58,https://en.wikipedia.org/wiki/ALGOL_58
                              |ALGOL 60,https://en.wikipedia.org/wiki/ALGOL_60
                              |ALGOL 68,https://en.wikipedia.org/wiki/ALGOL_68
                              |ALGOL W,https://en.wikipedia.org/wiki/ALGOL_W
                              |Alice,https://en.wikipedia.org/wiki/Alice_(programming_language)
                              |Alma-0,https://en.wikipedia.org/wiki/Alma-0
                              |AmbientTalk,https://en.wikipedia.org/wiki/AmbientTalk
                              |Amiga E,https://en.wikipedia.org/wiki/Amiga_E
                              |AMOS,https://en.wikipedia.org/wiki/AMOS_(programming_language)
                              |AMPL,https://en.wikipedia.org/wiki/AMPL
                              |Apex (Salesforce.com),https://en.wikipedia.org/wiki/Salesforce.com#Apex
                              |APL,https://en.wikipedia.org/wiki/APL_(programming_language)
                              |App Inventor for Android's visual block language,https://en.wikipedia.org/wiki/App_Inventor_for_Android_(programming_language)
                              |AppleScript,https://en.wikipedia.org/wiki/AppleScript
                              |Arc,https://en.wikipedia.org/wiki/Arc_(programming_language)
                              |ARexx,https://en.wikipedia.org/wiki/ARexx
                              |Argus,https://en.wikipedia.org/wiki/Argus_(programming_language)
                              |AspectJ,https://en.wikipedia.org/wiki/AspectJ
                              |Assembly language,https://en.wikipedia.org/wiki/Assembly_language
                              |ATS,https://en.wikipedia.org/wiki/ATS_(programming_language)
                              |Ateji PX,https://en.wikipedia.org/wiki/Ateji_PX
                              |AutoHotkey,https://en.wikipedia.org/wiki/AutoHotkey
                              |Autocoder,https://en.wikipedia.org/wiki/Autocoder
                              |AutoIt,https://en.wikipedia.org/wiki/AutoIt
                              |AutoLISP / Visual LISP,https://en.wikipedia.org/wiki/AutoLISP
                              |Averest,https://en.wikipedia.org/wiki/Averest
                              |AWK,https://en.wikipedia.org/wiki/AWK
                              |Axum,https://en.wikipedia.org/wiki/Axum_(programming_language)
                              |B,https://en.wikipedia.org/wiki/B_(programming_language)
                              |Babbage,https://en.wikipedia.org/wiki/Babbage_(programming_language)
                              |Bash,https://en.wikipedia.org/wiki/Bash_(Unix_shell)
                              |BASIC,https://en.wikipedia.org/wiki/BASIC
                              |bc,https://en.wikipedia.org/wiki/Bc_(programming_language)
                              |BCPL,https://en.wikipedia.org/wiki/BCPL
                              |BeanShell,https://en.wikipedia.org/wiki/BeanShell
                              |Batch (Windows/Dos),https://en.wikipedia.org/wiki/Batch_file
                              |Bertrand,https://en.wikipedia.org/wiki/Bertrand_(programming_language)
                              |BETA,https://en.wikipedia.org/wiki/BETA_(programming_language)
                              |Bigwig,https://en.wikipedia.org/wiki/Bigwig_(programming_language)
                              |Bistro,https://en.wikipedia.org/wiki/Bistro_(programming_language)
                              |BitC,https://en.wikipedia.org/wiki/BitC
                              |BLISS,https://en.wikipedia.org/wiki/BLISS_(programming_language)
                              |Blockly,https://en.wikipedia.org/wiki/Blockly
                              |BlooP,https://en.wikipedia.org/wiki/BlooP_and_FlooP
                              |Blue,https://en.wikipedia.org/wiki/Blue_(programming_language)
                              |Boo,https://en.wikipedia.org/wiki/Boo_(programming_language)
                              |Boomerang,https://en.wikipedia.org/wiki/Boomerang_(programming_language)
                              |Bourne shell (including,https://en.wikipedia.org/wiki/Bourne_shell
                              |bash and,https://en.wikipedia.org/wiki/Bash_(Unix_shell)
                              |ksh ),https://en.wikipedia.org/wiki/Korn_shell
                              |BREW,https://en.wikipedia.org/wiki/Qualcomm_Brew
                              |BPEL,https://en.wikipedia.org/wiki/Business_Process_Execution_Language
                              |C,https://en.wikipedia.org/wiki/C_(programming_language)
                              |C--,https://en.wikipedia.org/wiki/C--
                              |C++ – ISO/IEC 14882,https://en.wikipedia.org/wiki/C%2B%2B
                              |C# – ISO/IEC 23270,https://en.wikipedia.org/wiki/C_Sharp_(programming_language)
                              |C/AL,https://en.wikipedia.org/wiki/C/AL
                              |Caché ObjectScript,https://en.wikipedia.org/wiki/Cach%C3%A9_ObjectScript
                              |C Shell,https://en.wikipedia.org/wiki/C_Shell
                              |Caml,https://en.wikipedia.org/wiki/Caml
                              |Cayenne,https://en.wikipedia.org/wiki/Cayenne_(programming_language)
                              |CDuce,https://en.wikipedia.org/wiki/CDuce
                              |Cecil,https://en.wikipedia.org/wiki/Cecil_(programming_language)
                              |Cel,https://en.wikipedia.org/wiki/Cel_(programming_language)
                              |Cesil,https://en.wikipedia.org/wiki/Cesil
                              |Ceylon,https://en.wikipedia.org/wiki/Ceylon_(programming_language)
                              |CFEngine,https://en.wikipedia.org/wiki/CFEngine
                              |CFML,https://en.wikipedia.org/wiki/ColdFusion_Markup_Language
                              |Cg,https://en.wikipedia.org/wiki/Cg_(programming_language)
                              |Ch,https://en.wikipedia.org/wiki/Ch_(computer_programming)
                              |Chapel,https://en.wikipedia.org/wiki/Chapel_(programming_language)
                              |CHAIN,https://en.wikipedia.org/wiki/CHAIN_(programming_language)
                              |Charity,https://en.wikipedia.org/wiki/Charity_(programming_language)
                              |Charm,https://en.wikipedia.org/wiki/Charm_(language)
                              |Chef,https://en.wikipedia.org/wiki/Chef_(programming_language)
                              |CHILL,https://en.wikipedia.org/wiki/CHILL
                              |CHIP-8,https://en.wikipedia.org/wiki/CHIP-8
                              |chomski,https://en.wikipedia.org/wiki/Chomski
                              |ChucK,https://en.wikipedia.org/wiki/ChucK
                              |CICS,https://en.wikipedia.org/wiki/CICS
                              |Cilk,https://en.wikipedia.org/wiki/Cilk
                              |Citrine (programming language),https://en.wikipedia.org/wiki/Citrine_(programming_language)
                              |CL (IBM),https://en.wikipedia.org/wiki/AS/400_Control_Language
                              |Claire,https://en.wikipedia.org/wiki/Claire_(programming_language)
                              |Clarion,https://en.wikipedia.org/wiki/Clarion_(programming_language)
                              |Clean,https://en.wikipedia.org/wiki/Clean_(programming_language)
                              |Clipper,https://en.wikipedia.org/wiki/Clipper_(programming_language)
                              |CLIST,https://en.wikipedia.org/wiki/CLIST
                              |Clojure,https://en.wikipedia.org/wiki/Clojure
                              |CLU,https://en.wikipedia.org/wiki/CLU_(programming_language)
                              |CMS-2,https://en.wikipedia.org/wiki/CMS-2_(programming_language)
                              |COBOL – ISO/IEC 1989,https://en.wikipedia.org/wiki/COBOL
                              |Cobra,https://en.wikipedia.org/wiki/Cobra_(programming_language)
                              |CODE,https://en.wikipedia.org/wiki/CODE_(programming_language)
                              |CoffeeScript,https://en.wikipedia.org/wiki/CoffeeScript
                              |ColdFusion,https://en.wikipedia.org/wiki/ColdFusion
                              |COMAL,https://en.wikipedia.org/wiki/COMAL
                              |Combined Programming Language (CPL),https://en.wikipedia.org/wiki/Combined_Programming_Language
                              |COMIT,https://en.wikipedia.org/wiki/COMIT
                              |Common Intermediate Language (CIL),https://en.wikipedia.org/wiki/Common_Intermediate_Language
                              |Common Lisp (also known as CL),https://en.wikipedia.org/wiki/Common_Lisp
                              |COMPASS,https://en.wikipedia.org/wiki/COMPASS
                              |Component Pascal,https://en.wikipedia.org/wiki/Component_Pascal
                              |Constraint Handling Rules (CHR),https://en.wikipedia.org/wiki/Constraint_Handling_Rules
                              |Converge,https://en.wikipedia.org/wiki/Converge_(programming_language)
                              |Cool,https://en.wikipedia.org/wiki/Cool_(programming_language)
                              |Coq,https://en.wikipedia.org/wiki/Coq
                              |Coral 66,https://en.wikipedia.org/wiki/Coral_66
                              |Corn,https://en.wikipedia.org/wiki/Corn_(emulator)
                              |CorVision,https://en.wikipedia.org/wiki/CorVision
                              |COWSEL,https://en.wikipedia.org/wiki/COWSEL
                              |CPL,https://en.wikipedia.org/wiki/Combined_Programming_Language
                              |Cryptol,https://en.wikipedia.org/wiki/Cryptol
                              |csh,https://en.wikipedia.org/wiki/C_shell
                              |Csound,https://en.wikipedia.org/wiki/Csound
                              |CSP,https://en.wikipedia.org/wiki/Communicating_sequential_processes
                              |CUDA,https://en.wikipedia.org/wiki/CUDA
                              |Curl,https://en.wikipedia.org/wiki/Curl_(programming_language)
                              |Curry,https://en.wikipedia.org/wiki/Curry_(programming_language)
                              |Cyclone,https://en.wikipedia.org/wiki/Cyclone_(programming_language)
                              |Cython,https://en.wikipedia.org/wiki/Cython
                              |D,https://en.wikipedia.org/wiki/D_(programming_language)
                              |DASL (Datapoint's Advanced Systems Language),https://en.wikipedia.org/wiki/Datapoint%27s_Advanced_Systems_Language
                              |DASL (Distributed Application Specification Language),https://en.wikipedia.org/wiki/Distributed_Application_Specification_Language
                              |Dart,https://en.wikipedia.org/wiki/Dart_(programming_language)
                              |DataFlex,https://en.wikipedia.org/wiki/DataFlex
                              |Datalog,https://en.wikipedia.org/wiki/Datalog
                              |DATATRIEVE,https://en.wikipedia.org/wiki/DATATRIEVE
                              |dBase,https://en.wikipedia.org/wiki/DBase
                              |dc,https://en.wikipedia.org/wiki/Dc_(computer_program)
                              |DCL,https://en.wikipedia.org/wiki/DIGITAL_Command_Language
                              |Deesel (formerly G),https://en.wikipedia.org/wiki/Deesel
                              |Delphi,https://en.wikipedia.org/wiki/Delphi_(programming_language)
                              |DinkC,https://en.wikipedia.org/wiki/Dink_Smallwood#Modification
                              |DIBOL,https://en.wikipedia.org/wiki/DIBOL
                              |Dog,https://en.wikipedia.org/wiki/Sepandar_Kamvar#.22Dog.22_programming_language
                              |Draco,https://en.wikipedia.org/wiki/Draco_(programming_language)
                              |DRAKON,https://en.wikipedia.org/wiki/DRAKON
                              |Dylan,https://en.wikipedia.org/wiki/Dylan_(programming_language)
                              |DYNAMO,https://en.wikipedia.org/wiki/DYNAMO_(programming_language)
                              |E,https://en.wikipedia.org/wiki/E_(programming_language)
                              |E#,https://en.wikipedia.org/wiki/E_Sharp_(programming_language)
                              |Ease,https://en.wikipedia.org/wiki/Ease_(programming_language)
                              |Easy PL/I,https://en.wikipedia.org/wiki/PL/I
                              |Easy Programming Language,https://en.wikipedia.org/wiki/Easy_Programming_Language
                              |EASYTRIEVE PLUS,https://en.wikipedia.org/wiki/Easytrieve
                              |ECMAScript,https://en.wikipedia.org/wiki/ECMAScript
                              |Edinburgh IMP,https://en.wikipedia.org/wiki/Edinburgh_IMP
                              |EGL,https://en.wikipedia.org/wiki/EGL_(programming_language)
                              |Eiffel,https://en.wikipedia.org/wiki/Eiffel_(programming_language)
                              |ELAN,https://en.wikipedia.org/wiki/ELAN_(programming_language)
                              |Elixir,https://en.wikipedia.org/wiki/Elixir_(programming_language)
                              |Elm,https://en.wikipedia.org/wiki/Elm_(programming_language)
                              |Emacs Lisp,https://en.wikipedia.org/wiki/Emacs_Lisp
                              |Emerald,https://en.wikipedia.org/wiki/Emerald_(programming_language)
                              |Epigram,https://en.wikipedia.org/wiki/Epigram_(programming_language)
                              |EPL,https://en.wikipedia.org/wiki/Easy_Programming_Language
                              |Erlang,https://en.wikipedia.org/wiki/Erlang_(programming_language)
                              |es,https://en.wikipedia.org/wiki/Es_(Unix_shell)
                              |Escher,https://en.wikipedia.org/wiki/Escher_(programming_language)
                              |ESPOL,https://en.wikipedia.org/wiki/Executive_Systems_Problem_Oriented_Language
                              |Esterel,https://en.wikipedia.org/wiki/Esterel
                              |Etoys,https://en.wikipedia.org/wiki/Etoys_(programming_language)
                              |Euclid,https://en.wikipedia.org/wiki/Euclid_(programming_language)
                              |Euler,https://en.wikipedia.org/wiki/Euler_(programming_language)
                              |Euphoria,https://en.wikipedia.org/wiki/Euphoria_(programming_language)
                              |EusLisp Robot Programming Language,https://en.wikipedia.org/wiki/EusLisp_Robot_Programming_Language
                              |CMS EXEC (EXEC),https://en.wikipedia.org/wiki/CMS_EXEC
                              |EXEC 2,https://en.wikipedia.org/wiki/EXEC_2
                              |Executable UML,https://en.wikipedia.org/wiki/Executable_UML
                              |F,https://en.wikipedia.org/wiki/F_(programming_language)
                              |F#,https://en.wikipedia.org/wiki/F_Sharp_(programming_language)
                              |Factor,https://en.wikipedia.org/wiki/Factor_(programming_language)
                              |Falcon,https://en.wikipedia.org/wiki/Falcon_(programming_language)
                              |Fantom,https://en.wikipedia.org/wiki/Fantom_(programming_language)
                              |FAUST,https://en.wikipedia.org/wiki/FAUST_(programming_language)
                              |FFP,https://en.wikipedia.org/wiki/FFP_(programming_language)
                              |Fjölnir,https://en.wikipedia.org/wiki/Fj%C3%B6lnir_(programming_language)
                              |FL,https://en.wikipedia.org/wiki/FL_(programming_language)
                              |Flavors,https://en.wikipedia.org/wiki/Flavors_(programming_language)
                              |Flex,https://en.wikipedia.org/wiki/Flex_(language)
                              |FlooP,https://en.wikipedia.org/wiki/BlooP_and_FlooP
                              |FLOW-MATIC,https://en.wikipedia.org/wiki/FLOW-MATIC
                              |FOCAL,https://en.wikipedia.org/wiki/FOCAL_(programming_language)
                              |FOCUS,https://en.wikipedia.org/wiki/FOCUS
                              |FOIL,https://en.wikipedia.org/wiki/FOIL_(programming_language)
                              |FORMAC,https://en.wikipedia.org/wiki/FORMAC_(programming_language)
                              |@Formula,https://en.wikipedia.org/wiki/Formula_language
                              |Forth,https://en.wikipedia.org/wiki/Forth_(programming_language)
                              |Fortran – ISO/IEC 1539,https://en.wikipedia.org/wiki/Fortran
                              |Fortress,https://en.wikipedia.org/wiki/Fortress_(programming_language)
                              |FoxBase,https://en.wikipedia.org/wiki/FoxBase
                              |FoxPro,https://en.wikipedia.org/wiki/FoxPro
                              |FP,https://en.wikipedia.org/wiki/FP_(programming_language)
                              |FPr,https://en.wikipedia.org/wiki/FPr_(programming_language)
                              |Franz Lisp,https://en.wikipedia.org/wiki/Franz_Lisp
                              |Frege,https://en.wikipedia.org/wiki/Frege_(programming_language)
                              |F-Script,https://en.wikipedia.org/wiki/F-Script_(programming_language)
                              |G,https://en.wikipedia.org/wiki/G_(programming_language)
                              |Game Maker Language,https://en.wikipedia.org/wiki/GameMaker:_Studio
                              |GameMonkey Script,https://en.wikipedia.org/wiki/GameMonkey_Script
                              |GAMS,https://en.wikipedia.org/wiki/General_Algebraic_Modeling_System
                              |GAP,https://en.wikipedia.org/wiki/GAP_computer_algebra_system
                              |G-code,https://en.wikipedia.org/wiki/G-code
                              |Genie,https://en.wikipedia.org/wiki/Genie_(programming_language)
                              |GDL,https://en.wikipedia.org/wiki/Geometric_Description_Language
                              |GJ,https://en.wikipedia.org/wiki/Generic_Java
                              |GEORGE,https://en.wikipedia.org/wiki/GEORGE_(programming_language)
                              |GLSL,https://en.wikipedia.org/wiki/GLSL
                              |GNU E,https://en.wikipedia.org/wiki/GNU_E
                              |GM,https://en.wikipedia.org/wiki/Golden_master
                              |Go,https://en.wikipedia.org/wiki/Go_(programming_language)
                              |Go!,https://en.wikipedia.org/wiki/Go!_(programming_language)
                              |GOAL,https://en.wikipedia.org/wiki/Game_Oriented_Assembly_Lisp
                              |Gödel,https://en.wikipedia.org/wiki/G%C3%B6del_(programming_language)
                              |Godiva,https://en.wikipedia.org/wiki/Godiva_(programming_language)
                              |Golo,https://en.wikipedia.org/wiki/Golo_(programming_language)
                              |GOM (Good Old Mad),https://en.wikipedia.org/wiki/MAD_(programming_language)
                              |Google Apps Script,https://en.wikipedia.org/wiki/Google_Apps_Script
                              |Gosu,https://en.wikipedia.org/wiki/Gosu_(programming_language)
                              |GOTRAN,https://en.wikipedia.org/wiki/IBM_1620#GOTRAN
                              |GPSS,https://en.wikipedia.org/wiki/GPSS
                              |GraphTalk,https://en.wikipedia.org/wiki/Computer_Sciences_Corporation
                              |GRASS,https://en.wikipedia.org/wiki/GRASS_(programming_language)
                              |Groovy,https://en.wikipedia.org/wiki/Groovy_(programming_language)
                              |Hack,https://en.wikipedia.org/wiki/Hack_(programming_language)
                              |HAL/S,https://en.wikipedia.org/wiki/HAL/S
                              |Hamilton C shell,https://en.wikipedia.org/wiki/Hamilton_C_shell
                              |Harbour,https://en.wikipedia.org/wiki/Harbour_(software)
                              |Hartmann pipelines,https://en.wikipedia.org/wiki/Hartmann_pipeline
                              |Haskell,https://en.wikipedia.org/wiki/Haskell_(programming_language)
                              |Haxe,https://en.wikipedia.org/wiki/Haxe
                              |High Level Assembly,https://en.wikipedia.org/wiki/High_Level_Assembly
                              |HLSL,https://en.wikipedia.org/wiki/High_Level_Shader_Language
                              |Hop,https://en.wikipedia.org/wiki/Hop_(software)
                              |Hopscotch,https://en.wikipedia.org/wiki/Hopscotch_(programming_language)
                              |Hope,https://en.wikipedia.org/wiki/Hope_(programming_language)
                              |Hugo,https://en.wikipedia.org/wiki/Hugo_(programming_language)
                              |Hume,https://en.wikipedia.org/wiki/Hume_(language)
                              |HyperTalk,https://en.wikipedia.org/wiki/HyperTalk
                              |IBM Basic assembly language,https://en.wikipedia.org/wiki/IBM_Basic_assembly_language
                              |IBM HAScript,https://en.wikipedia.org/wiki/IBM_HAScript
                              |IBM Informix-4GL,https://en.wikipedia.org/wiki/IBM_Informix-4GL
                              |IBM RPG,https://en.wikipedia.org/wiki/IBM_RPG
                              |ICI,https://en.wikipedia.org/wiki/ICI_(programming_language)
                              |Icon,https://en.wikipedia.org/wiki/Icon_(programming_language)
                              |Id,https://en.wikipedia.org/wiki/Id_(programming_language)
                              |IDL,https://en.wikipedia.org/wiki/IDL_(programming_language)
                              |Idris,https://en.wikipedia.org/wiki/Idris_(programming_language)
                              |IMP,https://en.wikipedia.org/wiki/IMP_(programming_language)
                              |Inform,https://en.wikipedia.org/wiki/Inform
                              |Io,https://en.wikipedia.org/wiki/Io_(programming_language)
                              |Ioke,https://en.wikipedia.org/wiki/Ioke_(programming_language)
                              |IPL,https://en.wikipedia.org/wiki/Information_Processing_Language
                              |IPTSCRAE,https://en.wikipedia.org/wiki/IPTSCRAE
                              |ISLISP,https://en.wikipedia.org/wiki/ISLISP
                              |ISPF,https://en.wikipedia.org/wiki/ISPF
                              |ISWIM,https://en.wikipedia.org/wiki/ISWIM
                              |J,https://en.wikipedia.org/wiki/J_(programming_language)
                              |J#,https://en.wikipedia.org/wiki/J_Sharp
                              |J++,https://en.wikipedia.org/wiki/Visual_J%2B%2B
                              |JADE,https://en.wikipedia.org/wiki/JADE_(programming_language)
                              |Jako,https://en.wikipedia.org/wiki/Jako_(programming_language)
                              |JAL,https://en.wikipedia.org/wiki/JAL_(compiler)
                              |Janus (concurrent constraint programming language),https://en.wikipedia.org/wiki/Janus_(concurrent_constraint_programming_language)
                              |Janus (time-reversible computing programming language),https://en.wikipedia.org/wiki/Janus_(time-reversible_computing_programming_language)
                              |JASS,https://en.wikipedia.org/wiki/JASS
                              |Java,https://en.wikipedia.org/wiki/Java_(programming_language)
                              |JavaScript,https://en.wikipedia.org/wiki/JavaScript
                              |JCL,https://en.wikipedia.org/wiki/Job_Control_Language
                              |JEAN,https://en.wikipedia.org/wiki/JEAN
                              |Join Java,https://en.wikipedia.org/wiki/Join_Java
                              |JOSS,https://en.wikipedia.org/wiki/JOSS
                              |Joule,https://en.wikipedia.org/wiki/Joule_(programming_language)
                              |JOVIAL,https://en.wikipedia.org/wiki/JOVIAL
                              |Joy,https://en.wikipedia.org/wiki/Joy_(programming_language)
                              |JScript,https://en.wikipedia.org/wiki/JScript
                              |JScript .NET,https://en.wikipedia.org/wiki/JScript_.NET
                              |JavaFX Script,https://en.wikipedia.org/wiki/JavaFX_Script
                              |Julia,https://en.wikipedia.org/wiki/Julia_(programming_language)
                              |Jython,https://en.wikipedia.org/wiki/Jython
                              |K,https://en.wikipedia.org/wiki/K_(programming_language)
                              |Kaleidoscope,https://en.wikipedia.org/wiki/Kaleidoscope_(programming_language)
                              |Karel,https://en.wikipedia.org/wiki/Karel_(programming_language)
                              |Karel++,https://en.wikipedia.org/wiki/Karel%2B%2B
                              |KEE,https://en.wikipedia.org/wiki/IntelliCorp_(Software)
                              |Kixtart,https://en.wikipedia.org/wiki/KiXtart
                              |Klerer-May System,https://en.wikipedia.org/wiki/Klerer-May_System
                              |KIF,https://en.wikipedia.org/wiki/Knowledge_Interchange_Format
                              |Kojo,https://en.wikipedia.org/wiki/Kojo_(programming_language)
                              |Kotlin,https://en.wikipedia.org/wiki/Kotlin_(programming_language)
                              |KRC,https://en.wikipedia.org/wiki/Kent_Recursive_Calculator
                              |KRL,https://en.wikipedia.org/wiki/KRL_(programming_language)
                              |KUKA Robot Language),https://en.wikipedia.org/wiki/KUKA
                              |KRYPTON,https://en.wikipedia.org/wiki/KRYPTON
                              |ksh,https://en.wikipedia.org/wiki/Korn_shell
                              |L,https://en.wikipedia.org/wiki/L_(programming_language)
                              |L# .NET,https://en.wikipedia.org/wiki/L_Sharp
                              |LabVIEW,https://en.wikipedia.org/wiki/LabVIEW
                              |Ladder,https://en.wikipedia.org/wiki/Ladder_logic
                              |Lagoona,https://en.wikipedia.org/wiki/Lagoona_(programming_language)
                              |LANSA,https://en.wikipedia.org/wiki/LANSA_(development_environment)
                              |Lasso,https://en.wikipedia.org/wiki/Lasso_(programming_language)
                              |LaTeX,https://en.wikipedia.org/wiki/LaTeX
                              |Lava,https://en.wikipedia.org/wiki/Lava_(programming_language)
                              |LC-3,https://en.wikipedia.org/wiki/LC-3
                              |Leda,https://en.wikipedia.org/wiki/Leda_(programming_language)
                              |Legoscript,https://en.wikipedia.org/wiki/Lego_Mindstorms
                              |LIL,https://en.wikipedia.org/wiki/Little_Implementation_Language
                              |LilyPond,https://en.wikipedia.org/wiki/LilyPond
                              |Limbo,https://en.wikipedia.org/wiki/Limbo_(programming_language)
                              |Limnor,https://en.wikipedia.org/wiki/Limnor
                              |LINC,https://en.wikipedia.org/wiki/LINC_4GL
                              |Lingo,https://en.wikipedia.org/wiki/Lingo_(programming_language)
                              |LIS,https://en.wikipedia.org/wiki/LIS_(programming_language)
                              |LISA,https://en.wikipedia.org/wiki/Language_for_Instruction_Set_Architecture
                              |Lisaac,https://en.wikipedia.org/wiki/Lisaac
                              |Lisp – ISO/IEC 13816,https://en.wikipedia.org/wiki/Lisp_(programming_language)
                              |Lite-C,https://en.wikipedia.org/wiki/Lite-C
                              |Lithe,https://en.wikipedia.org/wiki/Lithe_(programming_language)
                              |Little b,https://en.wikipedia.org/wiki/Little_b_(programming_language)
                              |Logo,https://en.wikipedia.org/wiki/Logo_(programming_language)
                              |Logtalk,https://en.wikipedia.org/wiki/Logtalk
                              |LotusScript,https://en.wikipedia.org/wiki/LotusScript
                              |LPC,https://en.wikipedia.org/wiki/LPC_(programming_language)
                              |LSE,https://en.wikipedia.org/wiki/LSE_(programming_language)
                              |LSL,https://en.wikipedia.org/wiki/Linden_Scripting_Language
                              |LiveCode,https://en.wikipedia.org/wiki/LiveCode
                              |LiveScript,https://en.wikipedia.org/wiki/LiveScript
                              |Lua,https://en.wikipedia.org/wiki/Lua_(programming_language)
                              |Lucid,https://en.wikipedia.org/wiki/Lucid_(programming_language)
                              |Lustre,https://en.wikipedia.org/wiki/Lustre_(programming_language)
                              |LYaPAS,https://en.wikipedia.org/wiki/LYaPAS
                              |Lynx,https://en.wikipedia.org/wiki/Lynx_(programming_language)
                              |M2001,https://en.wikipedia.org/wiki/M2001
                              |MarsCode (programming language),
                              |M4,https://en.wikipedia.org/wiki/M4_(computer_language)
                              |M#,https://en.wikipedia.org/wiki/M_Sharp_(programming_language)
                              |Machine code,https://en.wikipedia.org/wiki/Machine_code
                              |MAD (Michigan Algorithm Decoder),https://en.wikipedia.org/wiki/MAD_(programming_language)
                              |MAD/I,https://en.wikipedia.org/wiki/MAD_(programming_language)
                              |Magik,https://en.wikipedia.org/wiki/Magik_(programming_language)
                              |Magma,https://en.wikipedia.org/wiki/Magma_computer_algebra_system
                              |make,https://en.wikipedia.org/wiki/Make_(software)
                              |Maple,https://en.wikipedia.org/wiki/Maple_(software)
                              |MAPPER now part of BIS,https://en.wikipedia.org/wiki/MAPPER
                              |MARK-IV now VISION:BUILDER,https://en.wikipedia.org/wiki/MARK_IV_(software)
                              |Mary,https://en.wikipedia.org/wiki/Mary_(programming_language)
                              |MASM Microsoft Assembly x86,https://en.wikipedia.org/wiki/Microsoft_Macro_Assembler
                              |MATH-MATIC,https://en.wikipedia.org/wiki/MATH-MATIC
                              |Mathematica,https://en.wikipedia.org/wiki/Mathematica
                              |MATLAB,https://en.wikipedia.org/wiki/MATLAB
                              |Maxima (see also,https://en.wikipedia.org/wiki/Maxima_(software)
                              |Macsyma ),https://en.wikipedia.org/wiki/Macsyma
                              |Max (Max Msp – Graphical Programming Environment),https://en.wikipedia.org/wiki/Max_(software)
                              |MaxScript internal language 3D Studio Max,https://en.wikipedia.org/wiki/Autodesk_3ds_Max
                              |Maya (MEL),https://en.wikipedia.org/wiki/Maya_Embedded_Language
                              |MDL,https://en.wikipedia.org/wiki/MDL_(programming_language)
                              |Mercury,https://en.wikipedia.org/wiki/Mercury_(programming_language)
                              |Mesa,https://en.wikipedia.org/wiki/Mesa_(programming_language)
                              |Metacard,https://en.wikipedia.org/wiki/Metacard
                              |Metafont,https://en.wikipedia.org/wiki/Metafont
                              |Microcode,https://en.wikipedia.org/wiki/Microassembler
                              |MicroScript,https://en.wikipedia.org/wiki/MicroScript_(programming_language)
                              |MIIS,https://en.wikipedia.org/wiki/MIIS_(programming_language)
                              |MillScript,https://en.wikipedia.org/wiki/MillScript
                              |MIMIC,https://en.wikipedia.org/wiki/MIMIC
                              |Mirah,https://en.wikipedia.org/wiki/Mirah_(programming_language)
                              |Miranda,https://en.wikipedia.org/wiki/Miranda_(programming_language)
                              |MIVA Script,https://en.wikipedia.org/wiki/MIVA_Script
                              |ML,https://en.wikipedia.org/wiki/ML_(programming_language)
                              |Moby,https://en.wikipedia.org/wiki/Moby_(programming_language)
                              |Model 204,https://en.wikipedia.org/wiki/Model_204
                              |Modelica,https://en.wikipedia.org/wiki/Modelica
                              |Modula,https://en.wikipedia.org/wiki/Modula
                              |Modula-2,https://en.wikipedia.org/wiki/Modula-2
                              |Modula-3,https://en.wikipedia.org/wiki/Modula-3
                              |Mohol,https://en.wikipedia.org/wiki/Mohol_programming_languages
                              |MOO,https://en.wikipedia.org/wiki/MOO_(programming_language)
                              |Mortran,https://en.wikipedia.org/wiki/Mortran
                              |Mouse,https://en.wikipedia.org/wiki/Mouse_(programming_language)
                              |MPD,https://en.wikipedia.org/wiki/MPD_(programming_language)
                              |CIL,https://en.wikipedia.org/wiki/Common_Intermediate_Language
                              |MSL,https://en.wikipedia.org/wiki/MIRC_scripting_language
                              |MUMPS,https://en.wikipedia.org/wiki/MUMPS
                              |Mystic Programming Language (MPL),https://en.wikipedia.org/wiki/Mystic_BBS
                              |NASM,https://en.wikipedia.org/wiki/Netwide_Assembler
                              |Napier88,https://en.wikipedia.org/wiki/Napier88
                              |Neko,https://en.wikipedia.org/wiki/Neko_(programming_language)
                              |Nemerle,https://en.wikipedia.org/wiki/Nemerle
                              |nesC,https://en.wikipedia.org/wiki/NesC
                              |NESL,https://en.wikipedia.org/wiki/NESL
                              |Net.Data,https://en.wikipedia.org/wiki/Net.Data
                              |NetLogo,https://en.wikipedia.org/wiki/NetLogo
                              |NetRexx,https://en.wikipedia.org/wiki/NetRexx
                              |NewLISP,https://en.wikipedia.org/wiki/NewLISP
                              |NEWP,https://en.wikipedia.org/wiki/NEWP
                              |Newspeak,https://en.wikipedia.org/wiki/Newspeak_(programming_language)
                              |NewtonScript,https://en.wikipedia.org/wiki/NewtonScript
                              |NGL,https://en.wikipedia.org/wiki/NGL_(programming_language)
                              |Nial,https://en.wikipedia.org/wiki/Nial
                              |Nice,https://en.wikipedia.org/wiki/Nice_(programming_language)
                              |Nickle,https://en.wikipedia.org/wiki/Nickle_(programming_language)
                              |Nim,https://en.wikipedia.org/wiki/Nim_(programming_language)
                              |NPL,https://en.wikipedia.org/wiki/NORD_Programming_Language
                              |Not eXactly C (NXC),https://en.wikipedia.org/wiki/Not_eXactly_C
                              |Not Quite C (NQC),https://en.wikipedia.org/wiki/Not_Quite_C
                              |NSIS,https://en.wikipedia.org/wiki/Nullsoft_Scriptable_Install_System
                              |Nu,https://en.wikipedia.org/wiki/Nu_(programming_language)
                              |NWScript,https://en.wikipedia.org/wiki/NWScript
                              |NXT-G,https://en.wikipedia.org/wiki/NXT-G
                              |o:XML,https://en.wikipedia.org/wiki/O:XML
                              |Oak,https://en.wikipedia.org/wiki/Oak_(programming_language)
                              |Oberon,https://en.wikipedia.org/wiki/Oberon_(programming_language)
                              |OBJ2,https://en.wikipedia.org/wiki/OBJ2
                              |Object Lisp,https://en.wikipedia.org/wiki/Object_Lisp
                              |ObjectLOGO,https://en.wikipedia.org/wiki/ObjectLOGO
                              |Object REXX,https://en.wikipedia.org/wiki/Object_REXX
                              |Object Pascal,https://en.wikipedia.org/wiki/Object_Pascal
                              |Objective-C,https://en.wikipedia.org/wiki/Objective-C
                              |Objective-J,https://en.wikipedia.org/wiki/Objective-J
                              |Obliq,https://en.wikipedia.org/wiki/Obliq
                              |OCaml,https://en.wikipedia.org/wiki/OCaml
                              |occam,https://en.wikipedia.org/wiki/Occam_(programming_language)
                              |occam-π,https://en.wikipedia.org/wiki/Occam-%CF%80
                              |Octave,https://en.wikipedia.org/wiki/GNU_Octave
                              |OmniMark,https://en.wikipedia.org/wiki/OmniMark
                              |Onyx,https://en.wikipedia.org/wiki/Onyx_(programming_language)
                              |Opa,https://en.wikipedia.org/wiki/Opa_(programming_language)
                              |Opal,https://en.wikipedia.org/wiki/Opal_(programming_language)
                              |OpenCL,https://en.wikipedia.org/wiki/OpenCL
                              |OpenEdge ABL,https://en.wikipedia.org/wiki/OpenEdge_Advanced_Business_Language
                              |OPL,https://en.wikipedia.org/wiki/Open_Programming_Language
                              |OPS5,https://en.wikipedia.org/wiki/OPS5
                              |OptimJ,https://en.wikipedia.org/wiki/OptimJ
                              |Orc,https://en.wikipedia.org/wiki/Orc_(programming_language)
                              |ORCA/Modula-2,https://en.wikipedia.org/wiki/ORCA/Modula-2
                              |Oriel,https://en.wikipedia.org/wiki/Oriel_(scripting_language)
                              |Orwell,https://en.wikipedia.org/wiki/Orwell_(programming_language)
                              |Oxygene,https://en.wikipedia.org/wiki/Oxygene_(programming_language)
                              |Oz,https://en.wikipedia.org/wiki/Oz_(programming_language)
                              |P′′,https://en.wikipedia.org/wiki/P%E2%80%B2%E2%80%B2
                              |P#,https://en.wikipedia.org/wiki/P_Sharp
                              |ParaSail (programming language),https://en.wikipedia.org/wiki/ParaSail_(programming_language)
                              |PARI/GP,https://en.wikipedia.org/wiki/PARI/GP
                              |Pascal – ISO 7185,https://en.wikipedia.org/wiki/Pascal_(programming_language)
                              |PCASTL,https://en.wikipedia.org/wiki/PCASTL
                              |PCF,https://en.wikipedia.org/wiki/Programming_language_for_Computable_Functions
                              |PEARL,https://en.wikipedia.org/wiki/PEARL_(programming_language)
                              |PeopleCode,https://en.wikipedia.org/wiki/PeopleCode
                              |Perl,https://en.wikipedia.org/wiki/Perl
                              |PDL,https://en.wikipedia.org/wiki/Perl_Data_Language
                              |Perl6,https://en.wikipedia.org/wiki/Perl6
                              |Pharo,https://en.wikipedia.org/wiki/Pharo
                              |PHP,https://en.wikipedia.org/wiki/PHP
                              |Phrogram,https://en.wikipedia.org/wiki/Phrogram
                              |Pico,https://en.wikipedia.org/wiki/Pico_(programming_language)
                              |Picolisp,https://en.wikipedia.org/wiki/Picolisp
                              |Pict,https://en.wikipedia.org/wiki/Pict_(programming_language)
                              |Pike,https://en.wikipedia.org/wiki/Pike_(programming_language)
                              |PIKT,https://en.wikipedia.org/wiki/PIKT
                              |PILOT,https://en.wikipedia.org/wiki/PILOT
                              |Pipelines,https://en.wikipedia.org/wiki/Hartmann_pipeline
                              |Pizza,https://en.wikipedia.org/wiki/Pizza_(programming_language)
                              |PL-11,https://en.wikipedia.org/wiki/PL-11
                              |PL/0,https://en.wikipedia.org/wiki/PL/0
                              |PL/B,https://en.wikipedia.org/wiki/Programming_Language_for_Business
                              |PL/C,https://en.wikipedia.org/wiki/PL/C
                              |PL/I – ISO 6160,https://en.wikipedia.org/wiki/PL/I
                              |PL/M,https://en.wikipedia.org/wiki/PL/M
                              |PL/P,https://en.wikipedia.org/wiki/PL/P
                              |PL/SQL,https://en.wikipedia.org/wiki/PL/SQL
                              |PL360,https://en.wikipedia.org/wiki/PL360
                              |PLANC,https://en.wikipedia.org/wiki/PLANC
                              |Plankalkül,https://en.wikipedia.org/wiki/Plankalk%C3%BCl
                              |Planner,https://en.wikipedia.org/wiki/Planner_(programming_language)
                              |PLEX,https://en.wikipedia.org/wiki/PLEX_(programming_language)
                              |PLEXIL,https://en.wikipedia.org/wiki/PLEXIL
                              |Plus,https://en.wikipedia.org/wiki/Plus_(programming_language)
                              |POP-11,https://en.wikipedia.org/wiki/POP-11
                              |PostScript,https://en.wikipedia.org/wiki/PostScript
                              |PortablE,https://en.wikipedia.org/wiki/Amiga_E#PortablE
                              |Powerhouse,https://en.wikipedia.org/wiki/Powerhouse_(programming_language)
                              |PowerBuilder – 4GL GUI applcation generator from Sybase,https://en.wikipedia.org/wiki/PowerBuilder
                              |PowerShell,https://en.wikipedia.org/wiki/PowerShell
                              |PPL,https://en.wikipedia.org/wiki/Polymorphic_Programming_Language
                              |Processing,https://en.wikipedia.org/wiki/Processing_(programming_language)
                              |Processing.js,https://en.wikipedia.org/wiki/Processing.js
                              |Prograph,https://en.wikipedia.org/wiki/Prograph
                              |PROIV,https://en.wikipedia.org/wiki/PROIV
                              |Prolog,https://en.wikipedia.org/wiki/Prolog
                              |PROMAL,https://en.wikipedia.org/wiki/PROMAL
                              |Promela,https://en.wikipedia.org/wiki/Promela
                              |PROSE modeling language,https://en.wikipedia.org/wiki/PROSE_modeling_language
                              |PROTEL,https://en.wikipedia.org/wiki/Protel
                              |ProvideX,https://en.wikipedia.org/wiki/ProvideX
                              |Pro*C,https://en.wikipedia.org/wiki/Pro*C
                              |Pure,https://en.wikipedia.org/wiki/Pure_(programming_language)
                              |Python,https://en.wikipedia.org/wiki/Python_(programming_language)
                              |Q (equational programming language),https://en.wikipedia.org/wiki/Q_(equational_programming_language)
                              |Q (programming language from Kx Systems),https://en.wikipedia.org/wiki/Q_(programming_language_from_Kx_Systems)
                              |Qalb,https://en.wikipedia.org/wiki/Qalb_(programming_language)
                              |QtScript,https://en.wikipedia.org/wiki/QtScript
                              |QuakeC,https://en.wikipedia.org/wiki/QuakeC
                              |QPL,https://en.wikipedia.org/wiki/Quantum_programming
                              |R,https://en.wikipedia.org/wiki/R_(programming_language)
                              |R++,https://en.wikipedia.org/wiki/R%2B%2B
                              |Racket,https://en.wikipedia.org/wiki/Racket_(programming_language)
                              |RAPID,https://en.wikipedia.org/wiki/RAPID
                              |Rapira,https://en.wikipedia.org/wiki/Rapira
                              |Ratfiv,https://en.wikipedia.org/wiki/Ratfiv
                              |Ratfor,https://en.wikipedia.org/wiki/Ratfor
                              |rc,https://en.wikipedia.org/wiki/Rc
                              |REBOL,https://en.wikipedia.org/wiki/REBOL
                              |Red,https://en.wikipedia.org/wiki/Red_(programming_language)
                              |Redcode,https://en.wikipedia.org/wiki/Core_War
                              |REFAL,https://en.wikipedia.org/wiki/REFAL
                              |Reia,https://en.wikipedia.org/wiki/Reia_(programming_language)
                              |Revolution,https://en.wikipedia.org/wiki/Revolution_(programming_language)
                              |REXX,https://en.wikipedia.org/wiki/REXX
                              |Rlab,https://en.wikipedia.org/wiki/Rlab
                              |ROOP,https://en.wikipedia.org/wiki/ROOP_(programming_language)
                              |RPG,https://en.wikipedia.org/wiki/IBM_RPG
                              |RPL,https://en.wikipedia.org/wiki/RPL_(programming_language)
                              |RSL,https://en.wikipedia.org/wiki/Robot_Battle#Robot_scripting_language
                              |RTL/2,https://en.wikipedia.org/wiki/RTL/2
                              |Ruby,https://en.wikipedia.org/wiki/Ruby_(programming_language)
                              |RuneScript,https://en.wikipedia.org/wiki/RuneScape#History_and_development
                              |Rust,https://en.wikipedia.org/wiki/Rust_(programming_language)
                              |S,https://en.wikipedia.org/wiki/S_(programming_language)
                              |S2,https://en.wikipedia.org/wiki/S2_(programming_language)
                              |S3,https://en.wikipedia.org/wiki/S3_(programming_language)
                              |S-Lang,https://en.wikipedia.org/wiki/S-Lang_(programming_language)
                              |S-PLUS,https://en.wikipedia.org/wiki/S-PLUS
                              |SA-C,https://en.wikipedia.org/wiki/SA-C_(programming_language)
                              |SabreTalk,https://en.wikipedia.org/wiki/SabreTalk
                              |SAIL,https://en.wikipedia.org/wiki/SAIL_(programming_language)
                              |SALSA,https://en.wikipedia.org/wiki/SALSA_(programming_language)
                              |SAM76,https://en.wikipedia.org/wiki/SAM76
                              |SAS,https://en.wikipedia.org/wiki/SAS_System
                              |SASL,https://en.wikipedia.org/wiki/SASL_(programming_language)
                              |Sather,https://en.wikipedia.org/wiki/Sather
                              |Sawzall,https://en.wikipedia.org/wiki/Sawzall_(programming_language)
                              |SBL,https://en.wikipedia.org/wiki/Superbase_database
                              |Scala,https://en.wikipedia.org/wiki/Scala_(programming_language)
                              |Scheme,https://en.wikipedia.org/wiki/Scheme_(programming_language)
                              |Scilab,https://en.wikipedia.org/wiki/Scilab
                              |Scratch,https://en.wikipedia.org/wiki/Scratch_(programming_language)
                              |Script.NET,https://en.wikipedia.org/wiki/Script.NET
                              |Sed,https://en.wikipedia.org/wiki/Sed
                              |Seed7,https://en.wikipedia.org/wiki/Seed7
                              |Self,https://en.wikipedia.org/wiki/Self_(programming_language)
                              |SenseTalk,https://en.wikipedia.org/wiki/SenseTalk
                              |SequenceL,https://en.wikipedia.org/wiki/SequenceL
                              |SETL,https://en.wikipedia.org/wiki/SETL
                              |SIMPOL,https://en.wikipedia.org/wiki/Superbase_database#History
                              |SIGNAL,https://en.wikipedia.org/wiki/SIGNAL_(programming_language)
                              |SiMPLE,https://en.wikipedia.org/wiki/SiMPLE
                              |SIMSCRIPT,https://en.wikipedia.org/wiki/SIMSCRIPT
                              |Simula,https://en.wikipedia.org/wiki/Simula
                              |Simulink,https://en.wikipedia.org/wiki/Simulink
                              |SISAL,https://en.wikipedia.org/wiki/SISAL
                              |SLIP,https://en.wikipedia.org/wiki/SLIP_(programming_language)
                              |SMALL,https://en.wikipedia.org/wiki/SMALL
                              |Smalltalk,https://en.wikipedia.org/wiki/Smalltalk
                              |Small Basic,https://en.wikipedia.org/wiki/Microsoft_Small_Basic
                              |SML,https://en.wikipedia.org/wiki/Standard_ML
                              |Snap!,https://en.wikipedia.org/wiki/Snap!_(programming_language)
                              |SNOBOL (,https://en.wikipedia.org/wiki/SNOBOL
                              |SPITBOL ),https://en.wikipedia.org/wiki/SPITBOL_compiler
                              |Snowball,https://en.wikipedia.org/wiki/Snowball_programming_language
                              |SOL,https://en.wikipedia.org/wiki/Secure_Operations_Language
                              |Span,https://en.wikipedia.org/wiki/Span_(programming_language)
                              |SPARK,https://en.wikipedia.org/wiki/SPARK_(programming_language)
                              |Speedcode,https://en.wikipedia.org/wiki/Speedcoding
                              |SPIN,https://en.wikipedia.org/wiki/Parallax_Propeller
                              |SP/k,https://en.wikipedia.org/wiki/SP/k
                              |SPS,https://en.wikipedia.org/wiki/IBM_1401_Symbolic_Programming_System
                              |SQR,https://en.wikipedia.org/wiki/SQR
                              |Squeak,https://en.wikipedia.org/wiki/Squeak
                              |Squirrel,https://en.wikipedia.org/wiki/Squirrel_(programming_language)
                              |SR,https://en.wikipedia.org/wiki/SR_(programming_language)
                              |S/SL,https://en.wikipedia.org/wiki/S/SL_programming_language
                              |Stackless Python,https://en.wikipedia.org/wiki/Stackless_Python
                              |Starlogo,https://en.wikipedia.org/wiki/Starlogo
                              |Strand,https://en.wikipedia.org/wiki/Strand_(programming_language)
                              |Stata,https://en.wikipedia.org/wiki/Stata
                              |Stateflow,https://en.wikipedia.org/wiki/Stateflow
                              |Subtext,https://en.wikipedia.org/wiki/Subtext_(programming_language)
                              |SuperCollider,https://en.wikipedia.org/wiki/SuperCollider
                              |SuperTalk,https://en.wikipedia.org/wiki/SuperTalk
                              |Swift (Apple programming language),https://en.wikipedia.org/wiki/Swift_(programming_language)
                              |Swift (parallel scripting language),https://en.wikipedia.org/wiki/Swift_(parallel_scripting_language)
                              |SYMPL,https://en.wikipedia.org/wiki/SYMPL
                              |SyncCharts,https://en.wikipedia.org/wiki/SyncCharts
                              |SystemVerilog,https://en.wikipedia.org/wiki/SystemVerilog
                              |T,https://en.wikipedia.org/wiki/T_(programming_language)
                              |TACL,https://en.wikipedia.org/wiki/TACL
                              |TACPOL,https://en.wikipedia.org/wiki/TACPOL_(programming_language)
                              |TADS,https://en.wikipedia.org/wiki/TADS
                              |TAL,https://en.wikipedia.org/wiki/Transaction_Application_Language
                              |Tcl,https://en.wikipedia.org/wiki/Tcl
                              |Tea,https://en.wikipedia.org/wiki/Tea_(programming_language)
                              |TECO,https://en.wikipedia.org/wiki/Text_Editor_and_Corrector
                              |TELCOMP,https://en.wikipedia.org/wiki/TELCOMP
                              |TeX,https://en.wikipedia.org/wiki/TeX
                              |TEX,https://en.wikipedia.org/wiki/Text_Executive_Programming_Language
                              |TIE,https://en.wikipedia.org/wiki/Tensilica_Instruction_Extension
                              |Timber,https://en.wikipedia.org/wiki/Timber_(programming_language)
                              |"TMG , compiler-compiler",https://en.wikipedia.org/wiki/TMG_(language)
                              |Tom,https://en.wikipedia.org/wiki/Tom_(pattern_matching_language)
                              |TOM,https://en.wikipedia.org/wiki/TOM_(object-oriented_programming_language)
                              |TouchDevelop,https://en.wikipedia.org/wiki/TouchDevelop
                              |Topspeed,https://en.wikipedia.org/wiki/Clarion_(programming_language)
                              |TPU,https://en.wikipedia.org/wiki/Text_Processing_Utility
                              |Trac,https://en.wikipedia.org/wiki/TRAC_(programming_language)
                              |TTM,https://en.wikipedia.org/wiki/TTM_(programming_language)
                              |T-SQL,https://en.wikipedia.org/wiki/Transact-SQL
                              |TTCN,https://en.wikipedia.org/wiki/TTCN
                              |Turing,https://en.wikipedia.org/wiki/Turing_(programming_language)
                              |TUTOR,https://en.wikipedia.org/wiki/TUTOR_(programming_language)
                              |TXL,https://en.wikipedia.org/wiki/TXL_(programming_language)
                              |TypeScript,https://en.wikipedia.org/wiki/TypeScript
                              |Turbo C++,https://en.wikipedia.org/wiki/Turbo_C%2B%2B
                              |Ubercode,https://en.wikipedia.org/wiki/Ubercode
                              |UCSD Pascal,https://en.wikipedia.org/wiki/UCSD_Pascal
                              |Umple,https://en.wikipedia.org/wiki/Umple
                              |Unicon,https://en.wikipedia.org/wiki/Unicon_(programming_language)
                              |Uniface,https://en.wikipedia.org/wiki/Uniface_(programming_language)
                              |UNITY,https://en.wikipedia.org/wiki/UNITY_(programming_language)
                              |Unix shell,https://en.wikipedia.org/wiki/Unix_shell
                              |UnrealScript,https://en.wikipedia.org/wiki/UnrealScript
                              |Vala,https://en.wikipedia.org/wiki/Vala_(programming_language)
                              |Visual DataFlex,https://en.wikipedia.org/wiki/Visual_DataFlex
                              |Visual DialogScript,https://en.wikipedia.org/wiki/Visual_DialogScript
                              |Visual Fortran,https://en.wikipedia.org/wiki/Visual_Fortran
                              |Visual FoxPro,https://en.wikipedia.org/wiki/Visual_FoxPro
                              |Visual J++,https://en.wikipedia.org/wiki/Visual_J%2B%2B
                              |Visual J#,https://en.wikipedia.org/wiki/Visual_J
                              |Visual Objects,https://en.wikipedia.org/wiki/Visual_Objects
                              |Visual Prolog,https://en.wikipedia.org/wiki/Visual_Prolog
                              |VSXu,https://en.wikipedia.org/wiki/VSXu
                              |vvvv,https://en.wikipedia.org/wiki/Vvvv
                              |"WATFIV, WATFOR",https://en.wikipedia.org/wiki/WATFIV_(programming_language)
                              |WebDNA,https://en.wikipedia.org/wiki/WebDNA
                              |WebQL,https://en.wikipedia.org/wiki/WebQL
                              |Whiley,https://en.wikipedia.org/wiki/Whiley_(programming_language)
                              |Windows PowerShell,https://en.wikipedia.org/wiki/Windows_PowerShell
                              |Winbatch,https://en.wikipedia.org/wiki/Winbatch
                              |Wolfram Language,https://en.wikipedia.org/wiki/Wolfram_Language
                              |Wyvern,https://en.wikipedia.org/wiki/Wyvern_(programming_language)
                              |X++,https://en.wikipedia.org/wiki/Microsoft_Dynamics_AX
                              |X#,https://en.wikipedia.org/wiki/X_Sharp_(programming_language)
                              |X10,https://en.wikipedia.org/wiki/X10_(programming_language)
                              |XBL,https://en.wikipedia.org/wiki/XBL
                              |XC (exploits,https://en.wikipedia.org/wiki/XC_Programming_Language
                              |XMOS architecture ),https://en.wikipedia.org/wiki/XCore_XS1
                              |xHarbour,https://en.wikipedia.org/wiki/XHarbour
                              |XL,https://en.wikipedia.org/wiki/XL_(programming_language)
                              |Xojo,https://en.wikipedia.org/wiki/Xojo
                              |XOTcl,https://en.wikipedia.org/wiki/XOTcl
                              |XPL,https://en.wikipedia.org/wiki/XPL
                              |XPL0,https://en.wikipedia.org/wiki/XPL0
                              |XQuery,https://en.wikipedia.org/wiki/XQuery
                              |XSB,https://en.wikipedia.org/wiki/XSB
                              |XSLT – see,https://en.wikipedia.org/wiki/XSL_Transformations
                              |XPath,https://en.wikipedia.org/wiki/XPath
                              |Xtend,https://en.wikipedia.org/wiki/Xtend
                              |Yorick,https://en.wikipedia.org/wiki/Yorick_(programming_language)
                              |YQL,https://en.wikipedia.org/wiki/YQL_(programming_language)
                              |Z notation,https://en.wikipedia.org/wiki/Z_notation
                              |Zeno,https://en.wikipedia.org/wiki/Zeno_(programming_language)
                              |ZOPL,https://en.wikipedia.org/wiki/ZOPL
                              |Zsh,https://en.wikipedia.org/wiki/Z_shell
                              |ZPL,https://en.wikipedia.org/wiki/ZPL_(programming_language)""".stripMargin
  programmingLanguages.split("\n").foreach(pl => programmingLanguageList = programmingLanguageList :+ (pl.split(",")(0).toLowerCase().replace(" ","-")))

  programmingLanguageList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",Programming Language"))
  certificationList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",Certification"))
  seniorityList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",Seniority"))
  toolsFrameworksList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",Tool/Framework"))
  roleList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",IT Specialization"))
  conceptList.toSet[String].toList.sortWith(_ < _).foreach(p => println(p + ",Programming Concept"))

  def generateTuple(word: String): (String, String) = {
    val category = word.toLowerCase match {
      case programmingLanguage if (programmingLanguageList.contains(programmingLanguage)) => "Programming Language"
      case certification if (certificationList.contains(certification)) => "Certification"
      case seniority if (seniorityList.contains(seniority)) => "Seniority"
      case toolsFrameworks if (toolsFrameworksList.contains(toolsFrameworks)) => "Tool/Framework"
      case role if (roleList.contains(role)) => "IT Specialization"
      case concept if (conceptList.contains(concept)) => "Programming Concept"
      case _ => "O"
    }
    if (word != ",")
      (word.replace("-", " "), category)
    else
      ("\",\"", category)

  }



  def splitSentencesInArrayOfWords(sentences: String): Array[String] = sentences
    .replace(",", " ,")
    .replace(".", " .")
    .replace("(", "( ")
    .replace(")", " )")
    .replace("\n", " ")
    .split(" ")


  def generateCsvFile(sentences: String, fileName: String): Unit = {
    val preProcessedSentences = splitSentencesInArrayOfWords(sentences)
    val csvFile = new PrintWriter(new File(fileName))
    preProcessedSentences
      .map(_.trim)
      .map(generateTuple)
      .foreach(tuple => csvFile.write(s"${tuple._1},${tuple._2}\n"))
    csvFile.close()

  }
  println("DRACU DRACU DRACU \n\n\n\n\n\n\n")
  trainSentences.split("\n").foreach(s => println(s"train,\"$s"))
  validationSentences.split("\n").foreach(s => println("validate,\"" + s ))
  testSentences.split("\n").foreach(s => println("test,\"" + s ))

  generateCsvFile(trainSentences,"train.csv")
  generateCsvFile(validationSentences,"validate.csv")
//  generateCsvFile(trainSentences,"test.csv")

}*/
