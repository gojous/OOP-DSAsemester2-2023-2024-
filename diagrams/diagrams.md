```mermaid
classDiagram
    class Chess {
        <<package>>
        engine
        gui
        pgn
    }

    class Engine {
        <<package>>
        classic
        player
        pieces
        board
    }

    class Classic {
        <<package>>
        Alliance
        Board
        Piece
        Player
        Move
    }

    class Player {
        BlackPlayer
        WhitePlayer
        AI
    }

    class Pieces {
        Piece
        King
        Queen
        Rook
        Bishop
        Knight
        Pawn
    }

    class Board {
        Move
        BoardUtils
        BoardEvaluator
    }

    class GUI {
        <<package>>
        Table
        GameSetup
        DebugPanel
        GameHistoryPanel
        TakenPiecesPanel
    }

    class PGN {
        <<package>>
        ParsePGNException
        PGNPersistence
        PGNUtilities
        PGNGameTags
        Playable
        FenUtilities
        Game
        GameFactory
        InvalidGame
        MySqlGamePersistence
        ValidGame
        PlayPGNException
    }

    class Network {
        <<package>>
        NetworkEntity
        Server
        Client
    }

    class Tests {
        <<package>>
        pgn
        ChessTestSuite
        TestAlphaBeta
        TestBoard
        TestCastling
        TestCheckmate
        TestEngine
        TestFENParser
        TestIterativeDeepening
        TestKingSafety
        TestMinMax
        TestPawnStructure
        TestPGNParser
        TestPieces
        TestPlayer
        TestRookStructure
        TestStaleMate
    }

    Chess --> Engine
    Chess --> GUI
    Chess --> PGN
    Chess --> Network
    Engine --> Classic
    Engine --> Player
    Engine --> Pieces
    Engine --> Board
    GUI --> Tests
    PGN --> Tests
    Network --> Tests
    Player --> AI
    Classic --> BoardUtils
    Classic --> BoardEvaluator
