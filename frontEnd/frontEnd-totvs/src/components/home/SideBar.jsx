import {useNavigate} from 'react-router-dom';

export default function SideBar() {

    const navigate = useNavigate();

    function cliente() {
        navigate("/cliente")
    }

    function dashBoard() {
        navigate("/dashboard")
    }

    return(
        <aside className="w-56 min-h-[calc(100vh-48px)] bg-[#263343] border-r border-[#3B4654]">

        <nav className="flex flex-col">

            <button onClick={dashBoard} className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ▣
                <br />
                    DashBoard
                </button>

            <button onClick={cliente} className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ♙
                <br />
                    Clients
                </button>

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ▥
                <br />
                    Analytics
                </button>

                <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ♙
                <br />
                    Companies
                </button>

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ⚙
                <br />
                    Settings
                </button>

        </nav>

    </aside>
    )
}