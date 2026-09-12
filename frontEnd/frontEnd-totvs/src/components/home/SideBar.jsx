

export default function SideBar() {

    return(
        <aside className="w-56 min-h-[calc(100vh-48px)] bg-[#263343] border-r border-[#3B4654]">

        <nav className="flex flex-col">

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ♙
                <br />
                    Contacts
                </button>

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ▣
                <br />
                    Companies
                </button>

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ♙
                <br />
                    Client
                </button>

            <button className="px-3 py-4 text-xl text-gray-300 hover:bg-[#344255] hover: cursor-pointer">
                ▥
                <br />
                    Analytics
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