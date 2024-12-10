interface TicketStatusProps {
  count: number;
  total: number;
}

function TicketStatus({ count, total }: TicketStatusProps) {
  return (
    <div className="ticket-status">
      <h2>Ticket Pool Status</h2>
      <p>
        Available Tickets: {count} / {total}
      </p>
      <progress value={count} max={total}></progress>
    </div>
  );
}

export default TicketStatus;
